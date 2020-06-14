package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.util.DropdownDto;

public class DropDownRowMapper implements RowMapper<DropdownDto>{
	
	@Override
	public DropdownDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		DropdownDto dropDownDto = new DropdownDto();
		dropDownDto.setLabel(rs.getString("ROLE"));
		dropDownDto.setValue(rs.getString("ROLE"));
		return dropDownDto;
	}

}
