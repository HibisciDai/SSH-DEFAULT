package org.fancyteam.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.Transient;
import org.fancyteam.dao.CategoryDao;
import org.fancyteam.entity.Category;
import org.fancyteam.service.CategoryService;
import org.springframework.stereotype.Service;
@Service("categoryServiceImpl")
public class CategoryServiceImpl   implements CategoryService{
       
	@Resource
	 private CategoryDao categoryDaoImpl;  //自动注入
	
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void save(Category t) {
		categoryDaoImpl.insert(t);
	}
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void update(Category t) {
		categoryDaoImpl.update(t, t.getId());
	}
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void delete(int id) {
		categoryDaoImpl.delete(id);
		
	}

	@Override
	public Category get(int id) {
		return categoryDaoImpl.findById(id);
	}

	@Override
	public List<Category> query() {
		return categoryDaoImpl.queryAll();
	}
	
}
