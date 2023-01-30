package se.lexickon.booklender.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexickon.booklender.Entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    // select * from app_user where username = 1
    // methode naming convention
    Optional<AppUser> findByUserName(String userName);
    //without  methode naming convention
    @Query("select  a from AppUser a where  a.userName= :un")
    Optional<AppUser> findByUsername(@Param("un") String userName);
   // methode naming convention
    //to select * from app_user where regDate between 12? 20?
    List<AppUser> findAllByRegDateBetween(LocalDate from, LocalDate to);
    // without the methode naming convention
    @Query("select  a from AppUser  a where a.regDate >= :from and a.regDate<= :to")
    List <AppUser> selectByRegistrationDate(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Modifying
    @Query("update AppUser a set a.password = :pw where a.userName = :un")
    void resetPassword(String username, String password);
}
