package com.gymbuddy.InstaApi.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "ErrorLog")
public class errorLog {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime timeStamp;
    private String message;
    private String details;
    private String HttpMethod;

    public errorLog(String httpMethod) {

        HttpMethod = httpMethod;
    }

    public errorLog() {

    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public errorLog(LocalDateTime timeStamp, String message, String details, String httpMethod) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
        HttpMethod = httpMethod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
