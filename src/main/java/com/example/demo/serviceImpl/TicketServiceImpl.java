/**
 * 
 */
package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketDao;
import com.example.demo.dto.NewTicketDto;
import com.example.demo.dto.TicketRequestDto;
import com.example.demo.dto.TicketResponseDto;
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
	public TicketResponseDto getTicket(TicketRequestDto ticketRequestDto) {
		// TODO Auto-generated method stub
		TicketResponseDto response = new TicketResponseDto();
		try {
			int fromIndex = ticketRequestDto.getPageIndex() * ticketRequestDto.getPageSize();
			int toIndex = (ticketRequestDto.getPageIndex() + 1) * ticketRequestDto.getPageSize();
			response = dao.getTicket(fromIndex, toIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public TicketResponseDto addTicket(NewTicketDto newTicketDto) {
		// TODO Auto-generated method stub
		int updatedRow = 0;
		TicketResponseDto response = new TicketResponseDto();
		try {
			int id = newTicketDto.getTotalTickets() + 1;
			int amount = newTicketDto.getNoOfPerson() * 200;
			updatedRow = dao.addTicket(newTicketDto, id, amount);
			if (updatedRow == 1) {
				int fromIndex = newTicketDto.getPageIndex() * newTicketDto.getPageSize();
				int toIndex = (newTicketDto.getPageIndex() + 1) * newTicketDto.getPageSize();
				response = dao.getTicket(fromIndex, toIndex);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
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
