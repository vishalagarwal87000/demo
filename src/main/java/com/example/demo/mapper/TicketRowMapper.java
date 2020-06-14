/**
 * 
 */
package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Ticket;

/**
 * @author prajw
 *
 */
public class TicketRowMapper implements RowMapper<Ticket> {

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ticket t = new Ticket();
		t.setId(rs.getInt("ID"));
		t.setCategory(rs.getString("CATEGORY"));
		t.setAmount(rs.getDouble("AMOUNT"));
		return t;

	}

}
