package com.example.user.UserHelpDesk.service;

import com.example.user.UserHelpDesk.common.APIResponse;
import com.example.user.UserHelpDesk.entity.UserHelpDeskEntity;
import com.example.user.UserHelpDesk.model.UserHelpDeskRequest;
import com.example.user.UserHelpDesk.repository.UserHelpDeskRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHelpDeskService {

    @Autowired
    private UserHelpDeskRepository userHelpDeskRepository;



    public APIResponse addHelpDesk(UserHelpDeskRequest userHelpDeskRequest) {
        APIResponse apiResponse = new APIResponse();
        try {
            UserHelpDeskEntity userHelpDeskEntity = new UserHelpDeskEntity();
            userHelpDeskEntity.setUserId(userHelpDeskRequest.getUserId());
            userHelpDeskEntity.setUserName(userHelpDeskRequest.getUserName());
            userHelpDeskEntity.setUserEmail(userHelpDeskRequest.getUserEmail());
            userHelpDeskEntity.setUserPhone(userHelpDeskRequest.getUserPhone());
            userHelpDeskEntity.setUserMessage(userHelpDeskRequest.getUserMessage());
            // Save the entity to the database
            userHelpDeskRepository.save(userHelpDeskEntity);
            apiResponse.setStatus(200);
            apiResponse.setMessage("User Help Desk Request Added Successfully");
            apiResponse.setData(userHelpDeskEntity);
        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while adding User Help Desk Request: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    public APIResponse getAllHelpDesk() {
        APIResponse apiResponse = new APIResponse();
        try {
            // Fetch all help desk requests from the database
            List<UserHelpDeskEntity> userHelpDeskEntities = userHelpDeskRepository.findAll();
            apiResponse.setStatus(200);
            apiResponse.setMessage("User Help Desk Requests Fetched Successfully");
            apiResponse.setData(userHelpDeskEntities);
        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while fetching User Help Desk Requests: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    public APIResponse updateHelpDesk(int userId, UserHelpDeskRequest userHelpDeskRequest) {
        APIResponse apiResponse = new APIResponse();
        try {
            // Fetch the existing help desk request by userId
                // Update the entity with new values
                UserHelpDeskEntity userHelpDeskEntity = new UserHelpDeskEntity();
                userHelpDeskEntity.setUserId(userHelpDeskRequest.getUserId());
                userHelpDeskEntity.setUserName(userHelpDeskRequest.getUserName());
                userHelpDeskEntity.setUserEmail(userHelpDeskRequest.getUserEmail());
                userHelpDeskEntity.setUserPhone(userHelpDeskRequest.getUserPhone());
                userHelpDeskEntity.setUserMessage(userHelpDeskRequest.getUserMessage());
                // Save the updated entity to the database
                userHelpDeskRepository.save(userHelpDeskEntity);
                apiResponse.setStatus(200);
                apiResponse.setMessage("User Help Desk Request Updated Successfully");
                apiResponse.setData(userHelpDeskEntity);

        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while updating User Help Desk Request: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    public APIResponse deleteHelpDesk(int userId) {
        APIResponse apiResponse = new APIResponse();
        try {
            // Fetch the existing help desk request by userId
            UserHelpDeskEntity userHelpDeskEntity = userHelpDeskRepository.findById((long) userId).orElse(null);
            if (userHelpDeskEntity != null) {
                // Delete the entity from the database
                userHelpDeskRepository.delete(userHelpDeskEntity);
                apiResponse.setStatus(200);
                apiResponse.setMessage("User Help Desk Request Deleted Successfully");
                apiResponse.setData(null);
            } else {
                apiResponse.setStatus(404);
                apiResponse.setMessage("User Help Desk Request Not Found");
                apiResponse.setData(null);
            }
        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while deleting User Help Desk Request: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    public APIResponse deleteAllHelpDesk() {
        APIResponse apiResponse = new APIResponse();
        try {
            // Delete all help desk requests from the database
            userHelpDeskRepository.deleteAll();
            apiResponse.setStatus(200);
            apiResponse.setMessage("All User Help Desk Requests Deleted Successfully");
            apiResponse.setData(null);
        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while deleting all User Help Desk Requests: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }

    public APIResponse getHelpDeskById(int userId) {
        APIResponse apiResponse = new APIResponse();
        try {
            List<UserHelpDeskEntity> userHelpDeskEntity = userHelpDeskRepository.findByUserId( userId);
            if (userHelpDeskEntity != null) {
                apiResponse.setStatus(200);
                apiResponse.setMessage("User Help Desk Data Fetched Successfully");
                apiResponse.setData(userHelpDeskEntity);
            } else {
                apiResponse.setStatus(404);
                apiResponse.setMessage("User Help Desk Request Not Found");
                apiResponse.setData(null);
            }
        } catch (Exception e) {
            apiResponse.setStatus(500);
            apiResponse.setMessage("Error while fetching User Help Desk Request: " + e.getMessage());
            apiResponse.setData(null);
        }
        return apiResponse;
    }
}
