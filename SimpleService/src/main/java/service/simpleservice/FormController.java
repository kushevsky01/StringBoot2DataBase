package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;


@RestController
public class FormController {
    @Autowired
    BookService books;
    @Autowired
    BookRepository bookrepo;

    @GetMapping("/books")
    public List getBooks(@RequestParam(value ="author", defaultValue="no author") String author, @RequestParam (value ="title", defaultValue="no title") String title) throws IOException {
        if(title.matches("[a-zA-z]+") &(author.matches("[a-zA-z]+"))){
            books.getBook(author, title);
        }
        return books.getAllBooks();
    }

    @GetMapping("/books/author/{author}")
    public List getBooksbyAuthor(@PathVariable("author") String author) throws IOException {
        return bookrepo.findAllBooksByAuthor(author);
    }

    @GetMapping("/books/title/{title}")
    public List getAuthorsBook(@PathVariable("title") String title) throws IOException {
        return bookrepo.findAuthorByTitle(title);
    }

    @GetMapping("/books/deleteById/{id}")
    public List deleteAuthor(@PathVariable("id") int id){
        books.delete(id);
        return  books.getAllBooks();
    }

}
