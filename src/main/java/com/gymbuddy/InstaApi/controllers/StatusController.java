package com.gymbuddy.InstaApi.controllers;

import com.gymbuddy.InstaApi.entitys.Status;
import com.gymbuddy.InstaApi.services.statusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    statusService service;

    @PostMapping("")
    private Status submitStatus(@RequestBody Status status) {
        return service.submitDataIntoDb(status);
    }
    @GetMapping("/all")
    private ArrayList<Status> getAllStatus(){
        return service.getAllStatusList();
    }
}
