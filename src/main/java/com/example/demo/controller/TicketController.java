/**
 * 
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.constants.UrlConstants;
import com.example.demo.dto.NewTicketDto;
import com.example.demo.dto.TicketRequestDto;
import com.example.demo.dto.TicketResponseDto;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import com.example.demo.xlparse.XLParser;

/**
 * @author prajw...
 * 
 *
 */
@Controller
public class TicketController {

	@Autowired
	private TicketService service;

	@Autowired
	private XLParser xLParser;

	@RequestMapping(value = UrlConstants.GET_TICKET)
	private ResponseEntity<Object> getTicket(@RequestBody TicketRequestDto ticketRequestDto) {
		TicketResponseDto response = new TicketResponseDto();
		try {
			response = service.getTicket(ticketRequestDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = UrlConstants.GET_EXPORT_DATA)
	private ResponseEntity<Object> getExportData() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			tickets = service.getExportData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = UrlConstants.UPLOAD_EXCEL)
	private ResponseEntity<Object> uploadExcel(@RequestPart("file") MultipartFile multipartFile) {
		List<Ticket> listTickets = null;
		try {
			listTickets = xLParser.readExcel(multipartFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(listTickets, HttpStatus.OK);
	}

	@RequestMapping(value = UrlConstants.ADD_TICKET)
	private ResponseEntity<Object> addTicket(@RequestBody NewTicketDto newTicketDto) {
		TicketResponseDto response = new TicketResponseDto();
		try {
			response = service.addTicket(newTicketDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = UrlConstants.GET_TICKET_DETAILS)
	private ResponseEntity<Object> getTicketDetails(@RequestBody Ticket ticket) {
		NewTicketDto data = new NewTicketDto();
		try {
			data = service.getTicketDetails(ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
