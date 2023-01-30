package se.lexickon.booklender.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data // Getter and Setter, EqualsAndHashCode and RequiredArgConstructor

@Entity

public class BookLoan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private  boolean returned;

@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private AppUser borrower;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Book book;

    public BookLoan(LocalDate loanDate, AppUser borrower, Book book) {
        this.dueDate = loanDate.plusDays(book.getMaxLoanDays());
        this.loanDate = loanDate;
        this.borrower = borrower;
        this.book = book;
        setBorrower(borrower);
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
        this.returned = (borrower == null);
    }
}

