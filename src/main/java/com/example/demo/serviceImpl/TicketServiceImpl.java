/**
 * 
 */
package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketDao;
import com.example.demo.dto.NewTicketDto;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

/**
 * @author prajw
 *
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao dao;

	@Override
	public List<Ticket> getTicket() {
		// TODO Auto-generated method stub
		List<Ticket> data = null;
		try {
			data = dao.getTicket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Ticket> addTicket(NewTicketDto newTicketDto) {
		// TODO Auto-generated method stub
		List<Ticket> data = null;
		try {
			int id = newTicketDto.getTotalTickets() + 1;
			int amount = newTicketDto.getNoOfPerson() * 200;
			data = dao.addTicket(newTicketDto, id, amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public NewTicketDto getTicketDetails(Ticket ticket) {
		// TODO Auto-generated method stub
		NewTicketDto data = null;
		try {
			data = dao.getTicketDetails(ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
