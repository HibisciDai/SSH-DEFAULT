package org.fancyteam.test.hibernate;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.fancyteam.dao.CategoryDao;
import org.fancyteam.entity.Category;
import org.fancyteam.service.CategoryService;
import org.fancyteam.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:org/fancyteam/config/beans.xml")
public class TestHibernate {

	/*
	 * @Test //测试Hibernate的开发环境，因为没有整合，可以直接new public void hihernate() {
	 * CategoryService categoryService = new CategoryServiceImpl(); Category
	 * category = new Category("男士休闲", true); categoryService.save(category); }
	 */
	@Resource
	private CategoryService CategoryServiceImpl;
	@Resource
	private CategoryDao categoryDaoImpl;

	@Test
	// 测试Hibernate和Spring整合后
	public void hibernateAndSpring() {
		// categoryDaoImpl.add(new Category( "22女式", true)); //
		// categoryService通过Spring从上面注入进来的
		System.out.println(CategoryServiceImpl.get(1));
	}
}