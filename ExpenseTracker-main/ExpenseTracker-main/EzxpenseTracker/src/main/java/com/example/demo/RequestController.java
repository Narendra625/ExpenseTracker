package com.example.demo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
public class RequestController {
	 String id;
	long loggedInuser;
	@Autowired
	userrepo rep;
	
	@Autowired
	ExpenseRepository reppo;
	
	@Autowired
	private ExpenseService expser;
	
	@Autowired
	ExpenseService expenseservice;
	
	@Autowired
	Feedbackrep feedrep;	

	
	@GetMapping("/")
	public String homied(){
		return "index";
	}
	
@GetMapping("/login")
public String homie(){
	return "login";
}
@GetMapping("/Register")
public String homiee() {
	return "Register";
}
@PostMapping("/registersubmit")
public String greets(User user) {
	rep.save(user);
	return "login";
}
@PostMapping("/loginsubmit")
public ModelAndView loginSubmit(User user){
User tempperson;
tempperson = rep.findByEmail(user.getEmail());
id = tempperson.getEmail();
ModelAndView mv  = new ModelAndView("home");
ModelAndView emv = new ModelAndView("register");  
mv.addObject(tempperson);
if(tempperson!=null && tempperson.getPassword().equals(user.getPassword())) {
	 return mv;
}
return emv;
}

@PostMapping("/submit")
public ModelAndView amountSubmit(User user,Model model){
	ModelAndView mav = new ModelAndView("home");
	User tperson = rep.findByEmail(id);
	User mail=rep.findByEmail(id);
	tperson.setAmount(user.getAmount()+tperson.getAmount());
	rep.save(tperson);
	mav.addObject(tperson);
	return mav;
}
@PostMapping("/expensesubmit")
public ModelAndView greeter(Expense exp,User user,Model model){
ModelAndView v=new ModelAndView("home");
 User person = rep.findByEmail(id);
 person.setAmount(person.getAmount()-user.getExpenseamount());
 rep.save(person);
 v.addObject(exp);
 v.addObject(person);
 exp.setEmail(id);
 reppo.save(exp);
 //int amt=rep.findByEmail(id).getAmount();
 return v;
 }

@GetMapping("/loginsubmit")
public String some(Model model,User user) {
	 int amount = rep.findByEmail(id).getAmount();
	  model.addAttribute("amount",amount);
	  return "home";
}
@GetMapping("/expense")
public String homies(Model model,User user){
	int amount = rep.findByEmail(id).getAmount();
	  model.addAttribute("amount",amount);
	  return "expense";
}

@GetMapping("/home")
public String homiesz(Model model,User user){
	int amount = rep.findByEmail(id).getAmount();
	  model.addAttribute("amount",amount);
	  String mails=rep.findByEmail(id).getEmail();
	  model.addAttribute("mails",mails);
	  return "success";
}


 
 //@GetMapping("/expensesubmit")
 //public String somese(Model model) {
 	// int amount = rep.findByEmail(id).getAmount();
 	//  model.addAttribute("amount",amount);
 	//  return "home";
 //}
 
@GetMapping("/History")
public String history(Model model){
	model.addAttribute("History",expser.getAllExpenseByEmail(id));
	return "History";
}

@GetMapping("/showFormForUpdate/{id}")
public String showFormforupdates(@PathVariable(value="id") long id,Model model) {
	Expense expense= expenseservice.getExpenseById(id);
	model.addAttribute("expenses",expense);
	return "update";
}

@RequestMapping("/home")
public String homiess(Model model){
	return "success";
}

@RequestMapping("/success")
public String homiessd(Model model){
	int amount = rep.findByEmail(id).getAmount();
	  model.addAttribute("amount",amount);
	return "success";
}

@GetMapping("/Feedback")
public String homieez() {
	return "Feedback";
}

@PostMapping("/feedbacksubmit")
public String greetsings(Feedback feedback) {
	feedrep.save(feedback);
	return "successful";
}

@RequestMapping("/piechart")
public ResponseEntity<?> getPiechart(){
	List<Expense> dd=reppo.findAll();
	return new ResponseEntity<>(dd,HttpStatus.OK);
}

@GetMapping("/barChart")
public String getAllEmployee(Model model) {	
	
List<String> nameList= expser.getAllExpenseByEmail(id).stream().map(x->x.getDescription()).collect(Collectors.toList());
List<Long> ageList = expser.getAllExpenseByEmail(id).stream().map(x-> x.getExpenseamount()).collect(Collectors.toList());
model.addAttribute("name", nameList);
model.addAttribute("amt", ageList);
return "Pie";

}


}
