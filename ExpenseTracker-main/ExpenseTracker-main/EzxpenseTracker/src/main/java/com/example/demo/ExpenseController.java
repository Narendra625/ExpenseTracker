package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Service
public class ExpenseController {
	
	
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	ExpenseService expenseservice;
	
	
	@GetMapping("/expenses")
	List<Expense> getExpenses(){
		return expenseRepository.findAll();
	}
	
//	@DeleteMapping("/expenses/{id}")
//	ResponseEntity<?>  deleteExpense(@PathVariable Long id){
//		expenseRepository.deleteById(id);
//		return ResponseEntity.ok().build();
	//}
	
	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException{
		Expense result= expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/expenses" + result.getId())).body(result);
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormforupdates(@PathVariable(value="id") long id,Model model) {
		Expense expense= expenseservice.getExpenseById(id);
		model.addAttribute("expenses",expense);
		return "update";
	}
	
	
}
