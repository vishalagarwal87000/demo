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
import com.example.demo.dto.NewTicketDto;
import com.example.demo.mapper.TicketRowMapper;
import com.example.demo.mapper.TicketSummaryRowMapper;
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
			String sql = TicketUtility.readProperties("getTickets");
			tickets = jdbcTemplate.query(sql, new TicketRowMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}

	public List<Ticket> addTicket(Ticket ticket) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		String sql1 = TicketUtility.readProperties("addTickets");
		String sql2 = TicketUtility.readProperties("showTickets");

		int result = jdbcTemplate.update(sql1, ticket.getId(), ticket.getAmount(), ticket.getCategory());
		if (result == 1) {
			tickets = jdbcTemplate.query(sql2, new TicketRowMapper());
		}
		return tickets;
	}

	@Override
	public List<Ticket> addTicket(NewTicketDto newTicketDto, int id, int amount) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
			String sql1 = TicketUtility.readProperties("addTickets");
			String sql2 = TicketUtility.readProperties("addTicketsSummary");

			int result1 = jdbcTemplate.update(sql1, id, amount, newTicketDto.getCategory());
			int result2 = jdbcTemplate.update(sql2, id, newTicketDto.getPersonName1(), newTicketDto.getPersonName2(),
					newTicketDto.getPersonName3(), newTicketDto.getPersonName4(), newTicketDto.getPersonName5());
			if (result1 == 1 && result2 == 1) {
				tickets = getTicket();
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public NewTicketDto getTicketDetails(Ticket ticket) {
		// TODO Auto-generated method stub
		NewTicketDto data = new NewTicketDto();
		try {
			String sql = TicketUtility.readProperties("getTicketDetails");
			data = jdbcTemplate.queryForObject(sql, new Object[] { ticket.getId() }, new TicketSummaryRowMapper());
			data.setCategory(ticket.getCategory());
			int noOfPerson = (int) (ticket.getAmount() / 200);
			data.setNoOfPerson(noOfPerson);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
