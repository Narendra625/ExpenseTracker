package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	List<Expense> findAllByEmail(String email);
}
