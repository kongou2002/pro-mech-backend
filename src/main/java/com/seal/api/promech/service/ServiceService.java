package com.seal.api.promech.service;


import com.seal.api.promech.entity.ServiceEntity;
import com.seal.api.promech.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public List<ServiceEntity> getAll() {
        return serviceRepository.findAll();
    }
}
