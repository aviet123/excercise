package service;

import controller.Category;
import controller.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private static List<Category> categories;

    static {
        categories = new ArrayList<>();
        categories.add(new Category(1,"Apple"));
        categories.add(new Category(2,"Samsung"));
    }


    public List<Category> findAll(){
        return categories;
    }

    public Category findById(int id) {
        Category p = new Category();
        for (Category category: categories){
            if (category.getId() == id)
                p = category;
        }
        return p;
    }
}
