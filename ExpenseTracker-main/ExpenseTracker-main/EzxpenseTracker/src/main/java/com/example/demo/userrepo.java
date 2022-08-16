package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface userrepo extends JpaRepository<User,String>{
User findByEmail(String email);
}