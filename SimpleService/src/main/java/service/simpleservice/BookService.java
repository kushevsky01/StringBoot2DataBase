package service.simpleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.simpleservice.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookrepo;

    public List getAllBooks() {
        List books = new ArrayList();
        bookrepo.findAll().forEach(book -> books.add(book));
        return books;
    }

    public void getBook(String author, String title) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookrepo.save(book);
    }

    public void delete(int id){
        bookrepo.deleteById(id);
    }
}

