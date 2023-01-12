package com.uniyaz.sakila.core.address.domain;

import com.uniyaz.sakila.core.city.domain.City;
import com.uniyaz.sakila.core.common.BaseEntity;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

@Table(name = "address")
@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private String id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @ForeignKey(name = "fk_address_city")
    private City city;

    @Column(name = "postal_code")
    private String postalCode;


    @Column(name = "phone")
    private String phone;

    @Column(name = "location")
    private String location;

    @Column(name = "last_update")
    private Date lastUpdate;


    @Override
    public Long getId() {
        return null;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Object getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", location=" + location +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
