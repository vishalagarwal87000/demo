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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constants.UrlConstants;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

/**
 * @author prajw
 *
 */
@Controller
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@RequestMapping(value = UrlConstants.GET_TICKET)
	private ResponseEntity<Object> getTicket() {
		List<Ticket> data = new ArrayList<Ticket>();
		try {
			data = service.getTicket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
//	@GetMapping("/getTicket")
//	private List<Ticket> getTicket(){
//		return (List<Ticket>) dao.findAll();
//	}
	

}
