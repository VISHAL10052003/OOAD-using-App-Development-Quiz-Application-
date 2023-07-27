package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Userentity;
import com.example.demo.service.Userservice;

@RestController
@CrossOrigin("http://localhost:3000")
public class Usercontroller
{
	@Autowired
	Userservice userservice;
	
	@PostMapping("/Userdetails")
	public boolean addUserentity(@RequestBody Userentity User)
	{
	return userservice.adduserentity(User);
	}
	@GetMapping("/showdetails")
	public List <Userentity> getAlluserentity()
	{
	return userservice.getAlluserentity();
	}

	
	
}