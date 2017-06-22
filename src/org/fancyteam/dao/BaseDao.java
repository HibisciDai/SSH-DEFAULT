package org.fancyteam.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	public abstract void insert(T t);

	public abstract void update(T t, Serializable id);
	
	public abstract void delete(int id);

	public abstract T findById(Serializable id);

	public abstract List<T> queryAll();
	
	//无条件的分页查询，pageIndex: 页码，默认第一页为1 ,pageSize: 每页的最大数量
	public abstract List<T> findPage(int pageIndex, int pageSize);
	
	//有条件的分页查询,pageIndex: 页码，默认第一页为1 ,pageSize: 每页的最大数量
	public abstract List<T> findPageByHql(int pageIndex, int pageSize, String hql);

}