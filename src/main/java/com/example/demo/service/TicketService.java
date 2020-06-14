/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.NewTicketDto;
import com.example.demo.model.Ticket;

/**
 * @author prajw
 *
 */
public interface TicketService {

	List<Ticket> getTicket();

	List<Ticket> addTicket(NewTicketDto newTicketDto);

	NewTicketDto getTicketDetails(Ticket ticket);

}
