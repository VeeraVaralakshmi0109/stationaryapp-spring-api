package com.stationaryapp.stationaryappapi.controller;

import java.util.List;
import java.util.Optional;

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

import com.stationaryapp.stationaryappapi.dao.UserRepository;
import com.stationaryapp.stationaryappapi.dto.MessageDTO;
import com.stationaryapp.stationaryappapi.model.User;
import com.stationaryapp.stationaryappapi.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

//	@PostMapping("users/save")
//	public User save(@RequestBody User user) {
//		System.out.println(user);
//		userRepository.save(user);
//		System.out.println("registered");
//		return user;
//
//	}

	@PostMapping("users/save")
	public ResponseEntity<?> addUser(@RequestBody User user) {

		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("users/login")
	public ResponseEntity login(@RequestBody User user) {

		try {
			Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (userObj.isPresent()) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

	@PutMapping("users/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);

	}

	@GetMapping("users/listUser")
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;

	}

	@GetMapping("users/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User obj = user.get();
			return obj;
		} else {
			return null;

		}
	}
}
