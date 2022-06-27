package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@RestController
public class FormController {
    @Autowired
    BookService books;
    @Autowired
    BookRepository bookrepo;

    @GetMapping("/books")
    public List getBooks(@RequestParam(value = "author", defaultValue = "no author") String author, @RequestParam(value = "title", defaultValue = "no title") String title) throws IOException {
        if (title.matches("[a-zA-z]+") & (author.matches("[a-zA-z]+"))) {
            books.getBook(author, title);
        }
        return books.getAllBooks();
    }

    @GetMapping("/books/author/{author}")
    public List getBooksbyAuthor(@PathVariable("author") String author) throws IOException {
        if (bookrepo.findAllBooksByAuthor(author).size() == 0 & author.matches("[a-zA-z]+")){
            return Collections.singletonList("This author not found");
        }else{
            return bookrepo.findAllBooksByAuthor(author);
        }
    }


    @GetMapping("/books/title/{title}")
    public List getAuthorsBook(@PathVariable("title") String title) throws IOException {
        if ((bookrepo.findAuthorByTitle(title)).size() == 0 & title.matches("[a-zA-z]+")) {
            return Collections.singletonList("Book with this title not found");
        } else {
            return bookrepo.findAuthorByTitle(title);
        }
    }

    @GetMapping("/books/deleteById/{id}")
    public List deleteAuthor(@PathVariable("id") String id) {

        if (id.matches("[0-9]+")){
            try {
                books.delete(Integer.parseInt(id));
                return books.getAllBooks();
            }catch (EmptyResultDataAccessException e){
                return Collections.singletonList("id not found");
            }
        }else{
            return Collections.singletonList("id must be integer");
        }
    }

}
