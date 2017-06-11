package com.olddrivers.tickets.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olddrivers.tickets.business.entities.Showing;
import com.olddrivers.tickets.business.entities.Ticket;
import com.olddrivers.tickets.business.entities.User;
import com.olddrivers.tickets.business.entities.service.ShowingService;
import com.olddrivers.tickets.business.entities.service.TicketService;
import com.olddrivers.tickets.business.entities.service.UserService;
import com.olddrivers.tickets.util.OrderForm;
import com.olddrivers.tickets.web.controllers.response.AbstractResponse;
import com.olddrivers.tickets.web.controllers.response.ObjectListResponse;

@Controller
@RequestMapping("/api/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShowingService showingService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse findOne(@PathVariable("id") String id) {
		Ticket t1 =  ticketService.findOne(id);
		AbstractResponse res = new AbstractResponse();
		res.put("showingId", t1.getShowing().getId());
		Integer[] seat = new Integer[2];
		seat[0] = t1.getSeatRowNum();
		seat[1] = t1.getSeatColNum();
 		res.put("seat", seat);
 		return res;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse findTicketsByUserId(@PathVariable("userId") String userId) {
		List<Ticket> tickets = ticketService.findTicketsByUserId(userId);
		List<String> ticketIdList = new ArrayList<String>();
		for (Ticket t : tickets) {
			ticketIdList.add(t.getId());
		}
		return new ObjectListResponse(ticketIdList,"ticketIdsList");
	}
	
	@RequestMapping(value = "/showing/{showingId}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractResponse findSoldTicketsByShowingId(@PathVariable("showingId") String showingId) {
		List<Ticket> tickets = ticketService.findSoldTicketsByShowingId(showingId);
		List<Integer[]> seatList = new ArrayList<Integer[]>();
		for (Ticket t : tickets) {
			Integer[] seat = new Integer[2];
			seat[0] = t.getSeatColNum();
			seat[1] = t.getSeatRowNum();
			seatList.add(seat);
		}
		return new ObjectListResponse(seatList,"seatSoldList");
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public AbstractResponse buyTickets(@RequestBody OrderForm orderForm) {
		
		List<String> ticketIds = new ArrayList<String>();
		
		User u1 = userService.findOne(orderForm.getUserId());
		Showing s1 = showingService.findOne(orderForm.getShowingId());
		for (int i = 0; i < orderForm.getCount(); i++) {
			Ticket temp = new Ticket();
			temp.setSeatRowNum(orderForm.getSeats()[i][0]);
			temp.setSeatColNum(orderForm.getSeats()[i][1]);
			temp.setIsSold(true);
			temp.setShowing(s1);
			temp.setUser(u1);
			ticketIds.add(ticketService.buyTicket(temp).getId());
		}
		return new ObjectListResponse(ticketIds, "ticketIds");
		
		
	}
}
