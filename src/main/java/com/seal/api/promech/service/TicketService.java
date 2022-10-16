package com.seal.api.promech.service;


import com.seal.api.promech.dto.Ticket;
import com.seal.api.promech.entity.TicketEntity;
import com.seal.api.promech.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    private Ticket convert(String body){
        Ticket t = new Ticket();
        int start = 0, end = 0, i=0;
        i = body.indexOf("name");
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        int temp=i;
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        if(i-temp > 2) {
            t.setName(null);
        }
        else {
            i++;
            int j=i;
            while(i<body.length() && body.charAt(i)!='"') i++;
            t.setName(body.substring(j,i));
        }


        i = body.indexOf("password");
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        temp=i;
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        if(i-temp > 2) {
            t.setPassword(null);
        }
        else {
            i++;
            int j=i;
            while(i<body.length() && body.charAt(i)!='"') i++;
            t.setPassword(body.substring(j,i));
        }


        i = body.indexOf("phone");
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        temp=i;
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        if(i-temp > 2) {
            t.setPhone(-1);
        }
        else {
            i++;
            int j=i;
            while(i<body.length() && body.charAt(i)!='"') i++;
            t.setPhone(Long.parseLong(body.substring(j,i)));
        }


        i = body.indexOf("description");
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        temp=i;
        i++;
        while(i<body.length() && body.charAt(i)!='"') i++;
        if(i-temp > 2) {
            t.setDescription(null);
        }
        else {
            i++;
            int j=i;
            while(i<body.length() && body.charAt(i)!='"') i++;
            t.setDescription(body.substring(j,i));
        }

//        service
        start = body.indexOf("service")+11;
        end = 0;
        i=0;
        String service = "";
        while (body.indexOf('"', start)!=-1){
            end =body.indexOf('"', start);
            if (i%2==0)
                service+= body.substring(start, end) + ", ";
            i++;
            start = end+1;
        }
        if (service.length()>=2)
            t.setService(service.substring(0, service.length()-2));
        return t;
    }

    public TicketEntity getTicketByPhone(int phone) {
        return ticketRepository.getByPhone(phone);
    }

    public List<TicketEntity> getAll() {
        return ticketRepository.getAll();
    }

    public Integer createTicket(String body){
        System.out.println(body);
        Ticket ticket = this.convert(body);
        return ticketRepository.createTicket(ticket.getPhone(), ticket.getName(), ticket.getPassword(), ticket.getDescription(), ticket.getService());
    }

    public Integer createTicket(Ticket ticket) {
        return ticketRepository.createTicket(ticket.getPhone(), ticket.getName(), ticket.getPassword(), ticket.getDescription(), ticket.getService());
    }

    public Integer updateTicket(Ticket ticket) {
        return ticketRepository.updateTicket(ticket.getTicketID(), ticket.getPhone(), ticket.getName(), ticket.getPassword(), ticket.getDescription(), ticket.getService());
    }

    public Integer confirmTicket(int id) {
        return ticketRepository.confirmTicket(id);
    }


}
