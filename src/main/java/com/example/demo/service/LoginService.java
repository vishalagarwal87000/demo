package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.util.DropdownDto;

public interface LoginService {

	List<DropdownDto> getRoles();

	int getUserDetails(String username);

	int newUserDetails(User userDetails);

}
