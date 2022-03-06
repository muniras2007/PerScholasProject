package casestudy.telehealth.database.dao;

import casestudy.telehealth.database.entity.User;
import casestudy.telehealth.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {

        public Optional<User> findById(@Param("id") Integer id);

        public User findByEmail(@Param("email") String email);
       // public User findByUserName(@Param("userName") String email);

        public List<User> findByLastName(@Param("lastName") String lastName);

        public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

        public List<User> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

        //@Query("select u from User u where u.firstName = :firstName or u.lastName = :lastName")
        public List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

        @Query("select u from User u where u.firstName = :firstName")
        public List<User> findByFirstName(String firstName);

        @Query("select u from User u where u.username = :username")
        public User findByUsername(@Param("username") String uname);

        @Query(value = "SELECT u.* FROM User u WHERE u.First_Name like '%:firstName%'", nativeQuery = true)
        public List<User> findByFirstNameLike(String firstName);


    }

