package BackEnd.repository;

import BackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Boolean existsByPassword(String password);
    Optional<User> findByUsernameAndPassword(String username, String password);
    // set status for account user by active = true
    @Query("SELECT u.statusActive  FROM  User u WHERE u.email = :email")
    User register(@Param("email") String email);

}