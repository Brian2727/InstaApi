package com.gymbuddy.InstaApi.repository;


import com.gymbuddy.InstaApi.entitys.errorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface errorLogRepo extends CrudRepository<errorLog, Integer> {
    errorLog save(errorLog errorlog);
    ArrayList<errorLog> findAll();
}
