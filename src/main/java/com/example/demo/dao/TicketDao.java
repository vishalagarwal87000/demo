/**
 * 
 */
package com.example.demo.dao;

import com.example.demo.dto.NewTicketDto;
import com.example.demo.dto.TicketResponseDto;
import com.example.demo.model.Ticket;

/**
 * @author prajw
 *
 */
public interface TicketDao {

	public TicketResponseDto getTicket(int fromIndex, int toIndex);

	public int addTicket(NewTicketDto newTicketDto, int id, int amount);

	public NewTicketDto getTicketDetails(Ticket ticket);

}
