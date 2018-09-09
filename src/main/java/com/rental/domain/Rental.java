package com.rental.domain;

import javax.persistence.*;
import java.util.List;

/**
 * POJO representing Rental entity.
 */
@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`_id`")
    private Integer rentalId;

    @Column(name = "`Record_ID`", length = 255)
    private String recordId;

    @Column(name = "`Street Number`")
    private Integer streetNumber;

    @Column(name = "`Street Name`", length = 255)
    private String streetName;

    @Column(name = "`City`", length = 255)
    private String city;

    @Column(name = "`State`", length = 255)
    private String state;

    @Column(name = "`Zip Code`", length = 255)
    private int zipCode;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="rentalId")
    private List<Tenant> tenantList;

    @Override
    public String toString(){
        return String.format(
                "Rental[rentalId=%d, streetNumber='%s', streetName='%s', city='%s', state='%s', zipCode='%s']",
                rentalId, streetNumber, streetName, city, state, zipCode);
    }
}
