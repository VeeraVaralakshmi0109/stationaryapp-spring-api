package com.stationaryapp.stationaryappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationaryapp.stationaryappapi.dao.UserRepository;
import com.stationaryapp.stationaryappapi.model.User;
import com.stationaryapp.stationaryappapi.validator.UserValidator;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserValidator userValidator;

	public String save(User user) throws Exception {

		// System.out.println(user);
		try {
			int verified=userValidator.userValidation(user);



			if(verified==1)
			{
				System.out.println(verified);
			 userRepository.save(user);
			 return "success";
			}
			return "failer";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();


		}
	}

}
