package com.gymbuddy.InstaApi.services;

import com.gymbuddy.InstaApi.entitys.Status;
import com.gymbuddy.InstaApi.repository.statusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class statusService {
    @Autowired
    statusRepo repo;

    public Status submitDataIntoDb(Status status){

        return repo.save(status);
    }

    public ArrayList<Status> getAllStatusList(){

        return repo.findAll();
    }
}
