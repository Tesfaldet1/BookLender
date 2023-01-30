package se.lexickon.booklender.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexickon.booklender.Entity.AppUser;
import se.lexickon.booklender.Entity.Details;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    AppUserRepository appUserDao;
     AppUser createdAppuser;
    @BeforeEach
    public void setup(){
        Details detailsData = new Details("user@test", "test test", LocalDate.parse("2023-01-01"));
        AppUser appUserData = new AppUser("user1", "password", detailsData);
        createdAppuser= appUserDao.save(appUserData);
        assertNotNull(createdAppuser);

    }
    public  void test_findById(){
        Optional <AppUser> appUserOptional= appUserDao.findById(createdAppuser.getId());
        assertTrue(appUserOptional.isPresent());
        AppUser actualData = appUserOptional.get();
        AppUser expectedData = createdAppuser;
        assertEquals(expectedData, actualData);
    }
    @Test

    public  void test_findByUserName(){
        Optional <AppUser> appUserOptional= appUserDao.findByUserName(createdAppuser.getUserName());
        assertTrue(appUserOptional.isPresent());
        AppUser actualData = appUserOptional.get();
        AppUser expectedData = createdAppuser;
        assertEquals(expectedData, actualData);
    }

}
