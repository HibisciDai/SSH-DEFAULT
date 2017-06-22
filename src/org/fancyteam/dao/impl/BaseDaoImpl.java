package org.fancyteam.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.fancyteam.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("baseDaoImpl")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz; // 存储T
	@Resource
	private SessionFactory sessionFactory; 

	public BaseDaoImpl() {
		super();
	}

	public BaseDaoImpl(Class clazz) {
		this.clazz = clazz;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t, Serializable id ){
		Session session = getSession();
//		Object obj = session.get(clazz, id);
//		obj = t ;
		session.merge(t);
		session.flush();
//		session.saveOrUpdate(clazz.getSimpleName(),obj);
	}

	@Override
	public void delete(int id) {
		String simpleClass = clazz.getSimpleName();
		String hql = "delete " + simpleClass + " where id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
	}

	@Override
	public List<T> queryAll() {
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public T findById(Serializable id) {
		return (T)getSession().get(clazz, id);
	}

	@Override
	public List<T> findPage(int pageIndex, int pageSize) {
		Query query = getSession().createQuery("from "+clazz.getSimpleName());
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return  query.list();
	}

	@Override
	public List<T> findPageByHql(int pageIndex, int pageSize, String hql) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
}
