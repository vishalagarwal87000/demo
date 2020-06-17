package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.util.DropdownDto;

public interface LoginDao {

	List<DropdownDto> getRoles();

	User getUserDetails(String username);

	int newUserDetails(User userDetails);

}
