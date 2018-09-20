package com.solstice.lab4.accountsaddress.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "Account")
public class Account {
    @Id
    @Column(name="ACCOUNT_ID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<Address> addresses;



}
