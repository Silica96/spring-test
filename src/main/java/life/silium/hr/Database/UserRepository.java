package life.silium.hr.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "select * from users;", nativeQuery = true)
    List<Users> findAllUsers();

//    @Query("select id,name,age,gender,salary from users where id = :id")
//    List<Users> findUserById(@Param("id") String id);
    List<Users> findOneProjectedById(int id);

    List<Users> findOneProjectedByName(String name);

//    @Modifying
//    @Query("delete from users where users.id=:id")
//    Boolean deleteId(@Param("id") int id);
    void deleteById(int id);
}
