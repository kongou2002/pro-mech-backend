package com.seal.api.promech.service;


import com.seal.api.promech.dto.Account;
import com.seal.api.promech.entity.TechnicalStaffEntity;
import com.seal.api.promech.repository.TechnicalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalStaffService {
    @Autowired
    TechnicalStaffRepository technicalStaffRepository;

    public TechnicalStaffEntity login(Account acc) {
        return technicalStaffRepository.login(acc.getPhone(), acc.getPassword());
    }
}
