package com.demo.repository;
import com.demo.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICharacterRepository extends JpaRepository<Character, Long> {

    @Query(value="SELECT * FROM characters WHERE name LIKE %:name%",
    nativeQuery = true)
    public List<Character> findByName(@Param("name") String name);

    @Query(value="SELECT * FROM characters WHERE age = :age",
            nativeQuery = true)
    public List<Character> findByAge(@Param("age") int age);


}
