package com.gymbuddy.InstaApi.repository;


import com.gymbuddy.InstaApi.entitys.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface statusRepo extends CrudRepository<Status, Integer> {

    Status save(Status status);
    ArrayList<Status> findAll();

}
