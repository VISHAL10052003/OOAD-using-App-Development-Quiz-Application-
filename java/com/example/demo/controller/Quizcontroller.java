package com.example.demo.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Quizentity;
import com.example.demo.service.Quizservice;


@RestController
@CrossOrigin("http://localhost:3000")
public class Quizcontroller {

	@Autowired
	Quizservice Quizservice;
	@PostMapping("/addques")
	public boolean addQuizentity(@RequestBody Quizentity Quizentity)
	{
	return Quizservice.addQuizentity(Quizentity);
	}
	
	
	@GetMapping("/showques")
	public List <Quizentity> getAllQuizentity()
	{
	return Quizservice.getAllQuizentity();
	}
	
	@GetMapping("/showques/{type}")
	public List <Quizentity> getByType(@PathVariable int type)
	{
	return Quizservice.getByType(type);
	}
	@PutMapping("/{id}")
	public Quizentity updateQuizentity( @RequestBody Quizentity ques,@PathVariable Integer id)
	{
	return Quizservice.updateQuizentity(id, ques);
	}
	@DeleteMapping("/{id}")
	public boolean deleteQuizentity(@PathVariable Integer id) {
	return Quizservice.deleteQuizentity(id);
	}
}