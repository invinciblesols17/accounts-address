package com.solstice.lab4.accountsaddress.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity /*@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
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

    public Address() {
    }

    public Address(String street, String aptBuilding, String city, String state, String zip, String country, Account account) {
        this.street = street;
        this.aptBuilding = aptBuilding;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.account = account;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAptBuilding() {
        return aptBuilding;
    }

    public void setAptBuilding(String aptBuilding) {
        this.aptBuilding = aptBuilding;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
