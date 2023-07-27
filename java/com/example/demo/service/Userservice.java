package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Userentity;
import com.example.demo.repository.Userrepo;

@Service
public class Userservice {
	@Autowired

	Userrepo userrepository;

	public boolean adduserentity(Userentity userentity) {
		return userrepository.save(userentity) != null ? true : false;
	}

	public List<Userentity> getAlluserentity() {
		return userrepository.findAll();
	}

	public String validateUser(String email, String password) {
		String result = "";
		Userentity u = userrepository.findByEmail(email);
		if (u == null) {
			result = "Invalid user";
		} else {
			if (u.getPassword().equals(password)) {
				result = "Login success";
			} else {
				result = "Login failed";
			}
		}
		return result;
	}
}