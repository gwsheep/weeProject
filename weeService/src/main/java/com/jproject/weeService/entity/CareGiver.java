package com.jproject.weeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "caregivers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CareGiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "caregiver_id")
    private Long caregiverId;
    @Column(name = "caregiver_pw")
    private String caregiverPw;
    @Column(name = "caregiver_name")
    private String careGiverName;
    @Column(name = "caregiver_age")
    private Long caregiverAge;
    @Column(name = "caregiver_gender")
    private String caregiverGender;
    @Column(name = "caregiver_pno")
    private String caregiverPhoneNo;
    @Column(name = "caregiver_address")
    private String caregiverAddress;
    @Column(name = "caregiver_mail")
    private String caregiverMail;
    @ManyToOne
    @JoinColumn(name = "nursinghome_id")
    private NursingHome nursingHome;

}
