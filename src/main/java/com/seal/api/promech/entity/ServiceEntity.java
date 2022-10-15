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
@Table(name = "Service")
public class ServiceEntity {
    @Id
    @Column(name = "ServiceID")
    private int serviceID;

    @Column(name = "ServiceName")
    private String serviceName;
}
