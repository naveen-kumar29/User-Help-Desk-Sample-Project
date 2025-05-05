package com.example.user.UserHelpDesk.controller;

import com.example.user.UserHelpDesk.common.APIResponse;
import com.example.user.UserHelpDesk.model.UserHelpDeskRequest;
import com.example.user.UserHelpDesk.service.UserHelpDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserHelpDeskController {

    @Autowired
    private UserHelpDeskService userHelpDeskService;

    @PostMapping("/add-help-desk")
    public APIResponse addHelpDesk(@RequestBody UserHelpDeskRequest userHelpDeskRequest) {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.addHelpDesk(userHelpDeskRequest);
        return apiResponse;
    }

    @GetMapping("/get-all-help-desk")
    public APIResponse getAllHelpDesk() {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.getAllHelpDesk();
        return apiResponse;
    }

    @PutMapping("/update-help-desk/{userId}")
    public APIResponse updateHelpDesk(@PathVariable int userId, @RequestBody UserHelpDeskRequest userHelpDeskRequest) {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.updateHelpDesk(userId, userHelpDeskRequest);
        return apiResponse;
    }

    @DeleteMapping("/delete-help-desk/{userId}")
    public APIResponse deleteHelpDesk(@PathVariable int userId) {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.deleteHelpDesk(userId);
        return apiResponse;
    }

    @DeleteMapping("/delete-all-help-desk")
    public APIResponse deleteAllHelpDesk() {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.deleteAllHelpDesk();
        return apiResponse;
    }

    @GetMapping("/get-help-desk-by-id/{userId}")
    public APIResponse getHelpDeskById(@PathVariable int userId) {
        APIResponse apiResponse = new APIResponse();
        apiResponse=userHelpDeskService.getHelpDeskById(userId);
        return apiResponse;
    }

}
