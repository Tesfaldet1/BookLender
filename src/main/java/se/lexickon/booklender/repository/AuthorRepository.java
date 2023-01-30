package se.lexickon.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexickon.booklender.Entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Integer>{
    List<Author> findAllByWrittenBooksId(int id);
    List<Author> findAllByWrittenBooksByTitle(String title);
    List<Author> findAllByWrittenBooksByIsbn(String isbn);
}
