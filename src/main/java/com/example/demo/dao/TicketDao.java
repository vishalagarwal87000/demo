/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.NewTicketDto;
import com.example.demo.model.Ticket;

/**
 * @author prajw
 *
 */
public interface TicketDao {

	public List<Ticket> getTicket();

	public List<Ticket> addTicket(NewTicketDto newTicketDto, int id, int amount);

	public NewTicketDto getTicketDetails(Ticket ticket);

}
