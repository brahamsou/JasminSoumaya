package fr.jasmin.model.dao.interfaces;

import java.util.List;

import fr.jasmin.entity.Category;

public interface ICategoryDao {
	void addCategory(Category category);
    Category getCategoryById(int id);
    void updateCategory(Category category);
    void deleteCategory(Category category);
    List<Category> getAllCategories();
}
