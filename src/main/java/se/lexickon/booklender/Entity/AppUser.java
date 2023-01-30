package se.lexickon.booklender.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import se.lexickon.booklender.exception.DataNotFoundException;
import se.lexickon.booklender.exception.DataDuplicateException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 80)
    private String userName;
    @Column(nullable = false, length = 80)
    private String password;
    @CreationTimestamp
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details details;
    @OneToMany(
            mappedBy = "borrower", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH}
    )
    private List<BookLoan> bookLoans = new ArrayList<>();


    public AppUser(String userName, String password, Details details) {
        this.userName = userName;
        this.password = password;
        this.details = details;
    }

    public boolean addBookLoan(BookLoan bookLoan) {
        if (bookLoans.contains(bookLoan)) {
            return false;
        }
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
        return true;
    }

    public boolean removeBookLoan(BookLoan bookLoan) {
        if (!bookLoans.contains(bookLoan)) {
            return false;
        }
        bookLoans.remove(bookLoan);
        bookLoan.setBook(null);
        return true;
    }
    /*
//// void methode
public void addBookLoan(BookLoan bookLoan){
    if(bookLoans.contains(bookLoan)){
        throw new DataDuplicateException("the data is duplicating");
    }
    bookLoans.add(bookLoan);
    bookLoan.setBorrower(this);
}
    public void removeBookLoan(BookLoan bookLoan) throws DataNotFoundException {
        if(!bookLoans.contains(bookLoan)){
            try {
                throw new DataNotFoundException("the data is duplicating");
            } catch (DataNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        bookLoans.remove(bookLoan);
        bookLoan.setBook(null);

     */



}
