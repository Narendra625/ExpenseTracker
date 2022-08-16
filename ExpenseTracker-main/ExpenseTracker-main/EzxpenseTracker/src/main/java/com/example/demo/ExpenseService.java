package com.example.demo;
import java.util.List;

public interface ExpenseService {
List<Expense> getAllExpenses();
List<Expense> getAllExpenseByEmail(String email);
Expense getExpenseById(long id);

}
