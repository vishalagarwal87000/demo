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
		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt("ID"));
		ticket.setCategory(rs.getString("CATEGORY"));
		ticket.setAmount(rs.getDouble("AMOUNT"));
		return ticket;

	}

}
