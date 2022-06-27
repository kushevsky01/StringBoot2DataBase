package service.simpleservice;

import org.springframework.data.jpa.repository.JpaRepository;
import service.simpleservice.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllBooksByAuthor(String author);

    List<Book> findAuthorByTitle(String title);

    long deleteByTitle(String title);

}
