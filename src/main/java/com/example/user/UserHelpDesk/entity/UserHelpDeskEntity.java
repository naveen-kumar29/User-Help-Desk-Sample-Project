package com.example.user.UserHelpDesk.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_help_desk")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserHelpDeskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userMessage;

}
