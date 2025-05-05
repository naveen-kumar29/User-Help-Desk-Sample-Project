package com.example.user.UserHelpDesk.repository;

import com.example.user.UserHelpDesk.entity.UserHelpDeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHelpDeskRepository extends JpaRepository<UserHelpDeskEntity,Long > {

    // Custom query methods can be defined here if needed
    // For example, you can add methods to find help desk requests by userId or other criteria
    List<UserHelpDeskEntity> findByUserId(Integer userId);


}
