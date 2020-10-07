package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CategoryService;
import service.ProductService;
import service.ProductServiceImpl;
import java.util.List;
import java.util.Random;

@Controller
public class ProductController {

    private final ProductService productService = new ProductServiceImpl();

    private final CategoryService categoryService = new CategoryService();

    @GetMapping("/")
    public String getIndex(Model model){
        List<Product> productList = productService.findAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("products",productList);
        model.addAttribute("categories",categories);
        return "index";
    }

    @GetMapping("/product/create")
    public String getCreateForm(Model model){

        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product){
        product.setId((int) (Math.random()*100));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String getEditForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product){
        productService.update(product.getId(),product);
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String deleteForm(@PathVariable int id , Model model){
       model.addAttribute("product", productService.findById(id));
       return "delete";
    }

    @PostMapping("/product/remove")
    public String delete(Product product)
    {
        productService.remove(product.getId());
        return "redirect:/";
    }
}
