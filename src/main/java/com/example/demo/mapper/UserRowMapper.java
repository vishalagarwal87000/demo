package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		u.setFirstName(rs.getString("FIRST_NAME"));
		u.setLastName(rs.getString("LAST_NAME"));
		u.setRole(rs.getString("ROLE"));
		u.setUserName(rs.getString("USERNAME"));
		return u;

	}

}
