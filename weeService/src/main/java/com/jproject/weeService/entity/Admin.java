package com.jproject.weeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "admin")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "admin_id")
    private Long adminId;
    @Column(name = "admin_pw")
    private String adminPw;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_pno")
    private String adminPhoneNo;
    @Column(name = "admin_address")
    private String adminAddress;
    @Column(name = "admin_mail")
    private String adminMail;

}
