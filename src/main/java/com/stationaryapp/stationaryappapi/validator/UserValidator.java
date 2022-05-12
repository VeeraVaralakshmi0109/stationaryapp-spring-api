package com.stationaryapp.stationaryappapi.validator;

import org.springframework.stereotype.Component;

import com.stationaryapp.stationaryappapi.model.User;

@Component
public class UserValidator {
	public int userValidation(User user) throws Exception {

		System.out.println(user);
		int count = 0;
		if(user.getName()==null || (user.getName()).trim()=="") {
			throw new Exception("Invalid Name");
		}
		else {
			count++;
		}
		if(user.getEmail()==null||(user.getEmail()).trim()=="") {
			throw new Exception("Invalid Email");
		}
		else {
			count++;
		}
		if(user.getPassword()==null ||(user.getPassword()).trim()=="") {
			throw new Exception("Invalid password");
		}
		else {
			count++;
		}
	
		if (user.getContact() == null || (user.getContact().length() != 10)) {
			throw new Exception("Invalid Contact---->Should have 10 number");
		} else {
			count++;
		}
		if (count == 4) {
			return 1;
		} else {
			return 0;
		}
	}

}
