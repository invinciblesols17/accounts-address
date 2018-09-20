package com.solstice.lab4.accountsaddress.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity @Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "APTBUILDING")
    private String aptBuilding;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;

    @Column(name = "COUNTRY")
    private String country;

    @ManyToOne
    @JsonBackReference
    private Account account;

}
