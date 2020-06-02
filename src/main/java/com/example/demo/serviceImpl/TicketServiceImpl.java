/**
 * 
 */
package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketDao;
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

	public List<Ticket> addTicket( Ticket ticket){
		List<Ticket> data = null;
		data = dao.addTicket(ticket);

		return data;
		
		
	}
	
}
