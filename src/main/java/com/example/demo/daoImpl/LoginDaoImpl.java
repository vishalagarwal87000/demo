package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.LoginDao;
import com.example.demo.mapper.DropDownRowMapper;
import com.example.demo.mapper.UserRowMapper;
import com.example.demo.model.User;
import com.example.demo.util.DropdownDto;
import com.example.demo.util.TicketUtility;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<DropdownDto> getRoles() {
		// TODO Auto-generated method stub
		List<DropdownDto> rolesList = new ArrayList<DropdownDto>();
		try {
			String sql = TicketUtility.readProperties("getRoles");
			rolesList = jdbcTemplate.query(sql, new DropDownRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rolesList;
	}

	@Override
	public int getUserDetails(String username) {
		// TODO Auto-generated method stub
		int access = 0;
		User user = null;
		try {
			String sql = TicketUtility.readProperties("getUserDetails");
			user = jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserRowMapper());
			if (user != null) {
				access = 1;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return access;
		}
		return access;
	}

	@Override
	public int newUserDetails(User userDetails) {
		// TODO Auto-generated method stub
		int updatedRow = 0;
		try {
			String sql1 = TicketUtility.readProperties("getUserCount");
			List<User> userList = jdbcTemplate.query(sql1, new UserRowMapper());
			int count = userList.size();
			count++;
			String sql = TicketUtility.readProperties("newUserDetails");
			updatedRow = jdbcTemplate.update(sql, count, userDetails.getFirstName(), userDetails.getLastName(),
					userDetails.getUserName(), userDetails.getRole(), userDetails.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedRow;
	}

}
