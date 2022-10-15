package com.seal.api.promech.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ticket")
public class TicketEntity {
    @Id
    @Column(name = "TicketID")
    private int ticketID;

    @Column(name = "Phone")
    private int phone;

    @Column(name = "Name")
    private String name;

    @Column(name = "Password")
    private String password;

    @Column(name = "Status")
    private int status;

    @Column(name = "Description")
    private String description;

    @Column(name = "Service")
    private String service;


}
