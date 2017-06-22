package org.fancyteam.dao.impl;

import org.fancyteam.dao.CategoryDao;
import org.fancyteam.entity.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDaoImpl")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao  {
  //(ˇˍˇ) 想～添加新方法 直接添加 接口方法，实现类调用 getSession 实现数据库持久
}
