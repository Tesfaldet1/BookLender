package se.lexickon.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexickon.booklender.Entity.BookLoan;

import java.awt.print.Book;
import java.util.List;
@Repository

public interface BookRepository extends CrudRepository<BookLoan, Integer> {
    List<Book> findAllByIsbn(String isbn);
    List<Book> findAllByTitleContains(String title);
    List<Book> findByTitleContainsIgnoreCase(String title);
}
