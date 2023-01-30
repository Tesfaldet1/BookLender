package se.lexickon.booklender.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false, length = 80)
    private String userName;
    @Column(nullable = false, length = 80)
    private  String password;
    @CreationTimestamp
    private LocalDate regDate;


    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
