package com.stationaryapp.stationaryappapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stationaryapp.stationaryappapi.dao.AdminRepository;
import com.stationaryapp.stationaryappapi.model.Admin;

@RestController
public class AdminController {

	@Autowired
	AdminRepository adminRepository;

	@PostMapping("admin/login")
	public Admin login(@RequestBody Admin admin) {
		Optional<Admin> adminObj = adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
		if (adminObj.isPresent()) {
			return adminObj.get();
		} else {
			return null;
		}

	}

}
