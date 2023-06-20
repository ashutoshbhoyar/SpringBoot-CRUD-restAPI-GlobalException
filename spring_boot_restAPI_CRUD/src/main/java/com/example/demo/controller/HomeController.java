package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomException.ResourseNotFound;
import com.example.demo.repository.UserRepository;
import com.example.demo.userEntity.User;

@RestController
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws ResourseNotFound {

		User user = userRepository.findById(id).orElseThrow(() -> new ResourseNotFound("User not found :: " + id));

		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		return userRepository.save(user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody User user) throws ResourseNotFound {

		User oldUser = userRepository.findById(id).orElseThrow(() -> new ResourseNotFound("user not found " + id));

		oldUser.setEmailId(user.getEmailId());
		oldUser.setFirstName(user.getFirstName());
		oldUser.setUpdatedAt(new Date());
		userRepository.save(oldUser);

		return new ResponseEntity<>(oldUser, HttpStatus.ACCEPTED);
	}

}
