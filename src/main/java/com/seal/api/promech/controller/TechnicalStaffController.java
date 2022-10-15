package com.seal.api.promech.controller;


import com.seal.api.promech.dto.Account;
import com.seal.api.promech.entity.TechnicalStaffEntity;
import com.seal.api.promech.service.TechnicalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TechnicalStaff")
public class TechnicalStaffController {
    @Autowired
    TechnicalStaffService technicalStaffService;
    @PostMapping("/Login")
    public TechnicalStaffEntity login(@ModelAttribute Account acc){
        TechnicalStaffEntity result = technicalStaffService.login(acc);
        return result;
    }
}