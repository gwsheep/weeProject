package com.jproject.weeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "nursinghomes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NursingHome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nurshinghome_id")
    private Long nurshinghomeId;
    @Column(name = "nurshinghome_pw")
    private String nurshinghomePw;
    @Column(name = "nurshinghome_name")
    private String nurshinghomeName;
    @Column(name = "nurshinghome_pno")
    private String nurshinghomePhoneNo;
    @Column(name = "nurshinghome_address")
    private String nurshinghomeAddress;
    @Column(name = "nurshinghome_mail")
    private String nurshinghomeMail;

}
