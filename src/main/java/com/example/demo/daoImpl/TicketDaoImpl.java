/**
 * 
 */
package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.TicketDao;
import com.example.demo.mapper.TicketRowMapper;
import com.example.demo.model.Ticket;
import com.example.demo.util.TicketUtility;

/**
 * @author prajw
 *
 */
@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Ticket> getTicket() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
			String sql = TicketUtility.readProperties("showTickets");
			tickets = jdbcTemplate.query(sql, new TicketRowMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}

}
