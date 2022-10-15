package com.seal.api.promech.controller;

import com.seal.api.promech.dto.Ticket;
import com.seal.api.promech.entity.TicketEntity;
import com.seal.api.promech.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/{phone}")
    public TicketEntity getTicketByPhone(@PathVariable int phone){
        return ticketService.getTicketByPhone(phone);
    }

    @GetMapping("/ALL")
    public List<TicketEntity> getTicketByPhone(){
        return ticketService.getAll();
    }

    @PostMapping("/CreateTicket")
    public ResponseEntity<?> createTicket(@RequestBody String body) {
        Integer result = ticketService.createTicket(body);
        if (result == 1)
            return ResponseEntity.ok(HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @PutMapping("/UpdateTicket")
    public ResponseEntity<?> updateJO(@ModelAttribute Ticket ticket) {
        Integer result = ticketService.updateTicket(ticket);
        if (result == 1)
            return ResponseEntity.ok(HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }

    @DeleteMapping("/ConfirmTicket")
    public ResponseEntity<?> confirmJO(@ModelAttribute Ticket ticket) {
        Integer result = ticketService.confirmTicket(ticket);
        if (result == 1)
            return ResponseEntity.ok(HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
}
