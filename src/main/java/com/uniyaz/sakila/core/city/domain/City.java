package com.uniyaz.sakila.core.city.domain;

import org.hibernate.annotations.ForeignKey;
import com.uniyaz.sakila.core.common.BaseEntity;
import com.uniyaz.sakila.core.country.domain.Country;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Table(name = "city")
@Entity
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city", length = 50)
    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id")
    @ForeignKey(name = "fk_city_country")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    @Transient
    private String testStr;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return city;
    }

    public String getTestStr() {
        return city;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}