package se.lexickon.booklender.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data // Getter and Setter, EqualsAndHashCode and RequiredArgConstructor

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   @JoinTable(name = "books_authors",
   joinColumns = @JoinColumn(name = "author_id"),
           inverseJoinColumns = @JoinColumn(name = "book_id")
   )

    private List<Book> writtenBooks = new ArrayList<>();
}
