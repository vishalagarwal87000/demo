package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.dto.NewTicketDto;

public class TicketSummaryRowMapper implements RowMapper<NewTicketDto> {

	@Override
	public NewTicketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewTicketDto ntd = new NewTicketDto();
		ntd.setPersonName1(rs.getString("PERSON 1"));
		ntd.setPersonName2(rs.getString("PERSON 2"));
		ntd.setPersonName3(rs.getString("PERSON 3"));
		ntd.setPersonName4(rs.getString("PERSON 4"));
		ntd.setPersonName5(rs.getString("PERSON 5"));
		return ntd;

	}

}
