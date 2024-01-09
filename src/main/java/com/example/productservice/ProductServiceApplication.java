package com.example.productservice;

import com.example.productservice.inheritencerelations.tableperclass.Student;
import com.example.productservice.inheritencerelations.tableperclass.StudentRepository;
import com.example.productservice.inheritencerelations.tableperclass.User;
import com.example.productservice.inheritencerelations.tableperclass.UserRepository;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    ProductServiceApplication(@Qualifier("tpcUserRepo") UserRepository userRepository,
        @Qualifier("tpcStudentRepo") StudentRepository studentRepository,
                              ProductRepository productRepository, CategoryRepository categoryRepository,
                              PriceRepository priceRepository){
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
        this.productRepository = productRepository;
        this.categoryRepository= categoryRepository;
        this.priceRepository = priceRepository;
    }
    public static void main(String[] args) {
       SpringApplication.run(ProductServiceApplication.class,args);
    }

    @Override
    @Transactional
    public void run(String... args) {
//       Product product=new Product("IPHONE 15","Nice iphone",new Price("INR",50000.0),
//               "https://xyz.com",new Category("Phones"));
//        productRepository.save(product);
        // Fetch existing category from the database or create a new one if needed
        Category category = categoryRepository.save(new Category("Phones"));
        Price price = priceRepository.save(new Price("INR",50000.0));
// Create a new Product and associate it with the Category
        Product product = new Product("IPHONE 15", "Nice iphone",price,
                "https://xyz.com", category);

// Save the Product
        productRepository.save(product);
        List<Product> productList= productRepository.findAllByCategory_Name("Phones");
    }
}
