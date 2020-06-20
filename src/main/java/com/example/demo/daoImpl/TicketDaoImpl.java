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
import com.example.demo.dto.TicketResponseDto;
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
	public TicketResponseDto getTicket(int offset, int size) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketResponseDto response = new TicketResponseDto();

		try {
			String sql = TicketUtility.readProperties("getTickets");
			String sql1 = TicketUtility.readProperties("countTickets");
			tickets = jdbcTemplate.query(sql, new Object[] { offset, size }, new TicketRowMapper());
			int length = jdbcTemplate.queryForObject(sql1, Integer.class);
			response.setTicket(tickets);
			response.setLength(length);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int addTicket(NewTicketDto newTicketDto, int amount) {
		// TODO Auto-generated method stub
		int updatedRow = 0;
		try {
			String sql = TicketUtility.readProperties("maxId");
			String sql1 = TicketUtility.readProperties("addTickets");
			String sql2 = TicketUtility.readProperties("addTicketsSummary");
			int id = jdbcTemplate.queryForObject(sql, Integer.class);
			id += 1;
			int result1 = jdbcTemplate.update(sql1, id, amount, newTicketDto.getCategory());
			int result2 = jdbcTemplate.update(sql2, id, newTicketDto.getPersonName1(), newTicketDto.getPersonName2(),
					newTicketDto.getPersonName3(), newTicketDto.getPersonName4(), newTicketDto.getPersonName5());
			if (result1 == 1 && result2 == 1) {
				updatedRow = 1;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedRow;
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

	@Override
	public List<Ticket> getExportData() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			String sql = TicketUtility.readProperties("getExportData");
			tickets = jdbcTemplate.query(sql, new TicketRowMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tickets;
	}
}
