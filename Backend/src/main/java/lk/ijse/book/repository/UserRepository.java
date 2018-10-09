package lk.ijse.book.repository;

import lk.ijse.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT nameWithInitials,accountType FROM user WHERE email=?1 && userPassword=?2 && accountType=?3", nativeQuery = true)
    List<Object[]> getLogin(String userName, String userPassword, String type);
}
