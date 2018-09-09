package com.rental.domain;

import javax.persistence.*;


@Entity
@Table(name="tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`name`", length = 255)
    private String name;

    @Column(name = "`rental_id`")
    private Integer rentalId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

