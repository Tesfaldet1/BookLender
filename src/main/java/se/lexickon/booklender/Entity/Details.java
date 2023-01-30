package se.lexickon.booklender.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data // Getter and Setter, EqualsAndHashCode and RequiredArgConstructor
@Entity

public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(unique = true, nullable = false, length = 30)
    private String email;
    @Column(nullable = false, length = 30)
    private String name;
    private LocalDate birthDate;

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
