package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constants.UrlConstants;
import com.example.demo.model.User;
import com.example.demo.service.LoginService;
import com.example.demo.util.DropdownDto;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;

	@RequestMapping(value = UrlConstants.GET_ROLES)
	private ResponseEntity<Object> getRoles() {
		List<DropdownDto> data = new ArrayList<DropdownDto>();
		try {
			data = service.getRoles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@RequestMapping(value = UrlConstants.GET_USER_DETAILS)
	public ResponseEntity<Object> getUserDetails(@RequestParam("username") String username){
		User user = new User();
		try {
			user = service.getUserDetails(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = UrlConstants.NEW_USER_DETAILS)
	public ResponseEntity<Object> newUserDetails(@RequestBody User userDetails){
		int updatedRow = 0;
		try {
			updatedRow = service.newUserDetails(userDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(updatedRow, HttpStatus.OK);
	}

}
