package com.jproject.weeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, name = "user_id")
    private String userId;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private Long userAge;
    @Column(name = "user_gender")
    private String userGender;
    @Column(name = "user_pno")
    private String userPhoneNo;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "user_mail")
    private String userMail;
    @ManyToOne
    @JoinColumn(name = "careGiver_id")
    private CareGiver careGiver;

}
