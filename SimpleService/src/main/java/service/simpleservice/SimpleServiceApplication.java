package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import service.simpleservice.domain.Book;

import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class SimpleServiceApplication {
    @Autowired
    static
    BookRepository books;

    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceApplication.class, args);
    }
}
