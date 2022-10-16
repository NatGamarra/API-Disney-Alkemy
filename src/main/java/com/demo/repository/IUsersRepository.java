package com.demo.repository;
import com.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByUsername(String username);

    public Boolean existsByUsername(String username);
}
