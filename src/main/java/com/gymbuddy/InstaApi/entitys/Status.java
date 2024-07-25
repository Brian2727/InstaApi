package com.gymbuddy.InstaApi.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;

@Entity(name = "Status")
public class Status {

    @Id
    @GeneratedValue
    private int id;

    private int statusId;
    private int userId;
    private String Path;
    private Timestamp timeStamp;

    public Status() {

    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Status(int statusId, Timestamp timeStamp, String path, int userId) {
        this.statusId = statusId;
        this.timeStamp = timeStamp;
        Path = path;
        this.userId = userId;
    }
}
