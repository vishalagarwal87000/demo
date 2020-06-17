package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;
import com.example.demo.model.User;
import com.example.demo.service.LoginService;
import com.example.demo.util.DropdownDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;

	@Override
	public List<DropdownDto> getRoles() {
		// TODO Auto-generated method stub
		List<DropdownDto> data = null;
		try {
			data = dao.getRoles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public User getUserDetails(String username) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = dao.getUserDetails(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int newUserDetails(User userDetails) {
		// TODO Auto-generated method stub
		int updatedRow = 0;
		try {
			updatedRow = dao.newUserDetails(userDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedRow;
	}

}
