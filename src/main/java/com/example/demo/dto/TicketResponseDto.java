package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Ticket;

public class TicketResponseDto {

	private List<Ticket> ticket;
	private int length;

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
