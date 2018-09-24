package com.rental.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * POJO representing Rental entity.
 */
@Entity
@Table(name = "rental")
public class Rental {

    private static final Logger logger = LoggerFactory.getLogger(Rental.class);

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

    @Column(name = "`Issue Date`", length = 255)
    private String issueDate;

    @Column(name = "`Expiration Date`", length = 255)
    private String expirationDate;

    @Column(name = "`Record Status`", length = 255)
    private String recordStatus;

    @Column(name = "`Address x coordinate`", length = 255)
    private String addressXCoordinate;

    @Column(name = "`Address y coordinate`", length = 255)
    private String addressYCoordinate;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Integer getStreetNumber() { return streetNumber; }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {return streetName;}

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

    public Date getIssueDate(){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        try {
            return formatter.parse(issueDate);
        }
        catch(Exception exception)
        {
            logger.error("An exception occurred. " + exception.getMessage());
        }
        return new Date();
    }

    public void setIssueDate(String issueDate){ this.issueDate = issueDate;}

    public Date getExpirationDate(){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        try {
            return formatter.parse(expirationDate);
        }
        catch(Exception exception)
        {
            logger.error("An exception occurred. " + exception.getMessage());
        }
        return new Date();
    }

    public void setExpirationDate(String expirationDate){ this.expirationDate = expirationDate;}

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAddressXCoordinate(){ return addressXCoordinate;}

    public void setAddressXCoordinate(String addressXCoordinate){ this.addressXCoordinate = addressXCoordinate;}

    public String getAddressYCoordinate(){ return addressYCoordinate;}

    public void setAddressYCoordinate(String addressYCoordinate){ this.addressYCoordinate = addressYCoordinate;}

    public List<Tenant> getTenantList(){ return tenantList; }

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
