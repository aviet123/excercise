package service;

import controller.Category;
import controller.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private static List<Product> products;

    private static List<Category> categories;

    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Iphone X",1,3000000));
        products.add(new Product(2,"Iphone 5s",1,4000000));
        products.add(new Product(3,"Iphone 6s",1,5000000));
        products.add(new Product(4,"Samsung Note7",2,2000000));
        products.add(new Product(5,"Iphone X",1,3000000));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean save(Product product) {
        return products.add(product);
    }

    @Override
    public Product findById(int id) {
        Product p = new Product();
        for (Product product: products){
            if (product.getId() == id)
                p = product;
        }
        return p;
    }

    @Override
    public boolean update(int id, Product product) {
        for (Product p: products){
            if (p.getId() == id){
                p.setName(product.getName());
                p.setBrand(product.getBrand());
                p.setPrice(product.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Product product: products){
            if (product.getId() == id){
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
