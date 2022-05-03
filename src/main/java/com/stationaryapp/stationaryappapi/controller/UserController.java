package com.stationaryapp.stationaryappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stationaryapp.stationaryappapi.dao.UserRepository;
import com.stationaryapp.stationaryappapi.model.User;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("users/save")
	public User save(@RequestBody User user) {
		System.out.println(user);
		userRepository.save(user);
		System.out.println("registered");
		return user;

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

