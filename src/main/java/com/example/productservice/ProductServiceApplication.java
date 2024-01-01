package com.example.productservice;

import com.example.productservice.inheritencerelations.tableperclass.Student;
import com.example.productservice.inheritencerelations.tableperclass.StudentRepository;
import com.example.productservice.inheritencerelations.tableperclass.User;
import com.example.productservice.inheritencerelations.tableperclass.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    ProductServiceApplication(@Qualifier("tpcUserRepo") UserRepository userRepository,
        @Qualifier("tpcStudentRepo") StudentRepository studentRepository){
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
    }
    public static void main(String[] args) {
       SpringApplication.run(ProductServiceApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Hi");
        Student student=new Student();
        User user = new User();
        user.setName("ExampleName1");
        user.setEmail("ExampleName1@email.com");
        studentRepository.save(student);
        userRepository.save(user);
    }
}
