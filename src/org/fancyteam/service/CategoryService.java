package org.fancyteam.service;

import java.util.List;
import org.fancyteam.entity.Category;

public interface CategoryService {
	public void save(Category t);

	public void update(Category t);

	public void delete(int id);

	public Category get(int id);

	public List<Category> query();
}