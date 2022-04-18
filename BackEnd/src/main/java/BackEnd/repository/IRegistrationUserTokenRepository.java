package BackEnd.repository;


import BackEnd.mail_confirm.RegistrationUserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Long> {
    RegistrationUserToken findByToken(String token);

    Boolean existsByToken(String token);

    @Transactional
    @Modifying
    @Query("DELETE FROM RegistrationUserToken r WHERE r.account.id = :accId")
    void deleteTokenByUserId(Long userId);

    @Query("select r.token from RegistrationUserToken r where r.account.id = :accId")
    String findActiveTokenByUserId(Long userId);
}