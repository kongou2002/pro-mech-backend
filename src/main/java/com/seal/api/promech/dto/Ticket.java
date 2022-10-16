package com.seal.api.promech.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket {
    private int ticketID;
    private long phone;
    private String name;
    private String password;

    private String description;

    private String service;
}
