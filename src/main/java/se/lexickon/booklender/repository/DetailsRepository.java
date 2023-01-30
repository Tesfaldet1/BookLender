package se.lexickon.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexickon.booklender.Entity.AppUser;
import se.lexickon.booklender.Entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository

public interface DetailsRepository extends CrudRepository<Details, Integer> {

    Optional<Details> findAllByEmailIgnoreCase(String email);
    List<Details> findAllByNameContains(String name);
    List<Details> findAllByNameIgnoreCaseAndBirthDate(String name, LocalDate birthDate);

}
