package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Expenseserviceimpl implements ExpenseService{

	
	@Autowired
	private ExpenseRepository exprep;
	
	@Override
	public List<Expense> getAllExpenses() {
		return exprep.findAll();
	}

	public List<Expense> getAllExpenseByEmail(Iterable<Long> email) {
		return exprep.findAllById(email);
	}

	@Override
	public List<Expense> getAllExpenseByEmail(String email) {
		List<Expense> optional=exprep.findAllByEmail(email);
		return 	(List<Expense>) optional;
	}

	@Override
	public  Expense getExpenseById(long id) {
		Optional<Expense> optional=exprep.findById(id);
		Expense expense=null;
		if(optional.isPresent()) {
			expense=optional.get();
		}
		else {
			throw new RuntimeException("Expense not found for id :" + id);
		}
		return expense;
	}


	
}
