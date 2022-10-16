package com.demo.repository;
import com.demo.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {

    public Optional<Rol> findByName(String name);
}
