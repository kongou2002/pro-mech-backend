package com.seal.api.promech.controller;

import com.seal.api.promech.entity.ServiceEntity;
import com.seal.api.promech.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @GetMapping("/ALL")
    List<ServiceEntity> getAll(){
        return serviceService.getAll();
    }
}
