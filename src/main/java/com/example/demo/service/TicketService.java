/**
 * 
 */
package com.example.demo.service;

import com.example.demo.dto.NewTicketDto;
import com.example.demo.dto.TicketRequestDto;
import com.example.demo.dto.TicketResponseDto;
import com.example.demo.model.Ticket;

/**
 * @author prajw
 *
 */
public interface TicketService {

	TicketResponseDto getTicket(TicketRequestDto ticketRequestDto);

	TicketResponseDto addTicket(NewTicketDto newTicketDto);

	NewTicketDto getTicketDetails(Ticket ticket);

}
