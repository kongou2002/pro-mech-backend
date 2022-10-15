package com.seal.api.promech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketForm {
    private Integer ticketID;
    private Integer phone;
    private String name;
    private String password;
    private String description;
    private List<String> service;
}
