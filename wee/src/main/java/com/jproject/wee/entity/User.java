package com.jproject.wee.entity;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "age")
    private Long age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "address")
    private String address;
    @Column(name = "mail")
    private String mail;

}
