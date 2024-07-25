package com.gymbuddy.InstaApi.services;


import com.gymbuddy.InstaApi.entitys.errorLog;
import com.gymbuddy.InstaApi.repository.errorLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class errorLogService {

    @Autowired
    errorLogRepo service;

    public void errorLogSubmit(errorLog log) {
        System.out.println("errorLog");
        service.save(log);
    }
}
