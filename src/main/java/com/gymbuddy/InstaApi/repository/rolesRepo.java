package com.gymbuddy.InstaApi.repository;

import com.gymbuddy.InstaApi.entitys.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolesRepo extends JpaRepository<Roles, Integer> {
    Roles findByRole(String name);
}
