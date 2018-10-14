package com.rajim.ehcache.doman;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author rajim on 10/14/18
 */
@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;
}
