package com.example.user.UserHelpDesk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserHelpDeskRequest {


    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userMessage;
}
