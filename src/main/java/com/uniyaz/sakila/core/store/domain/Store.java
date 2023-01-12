package com.uniyaz.sakila.core.store.domain;

import com.uniyaz.sakila.core.address.domain.Address;
import com.uniyaz.sakila.core.common.BaseEntity;
import com.uniyaz.sakila.core.staff.domain.Staff;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id")
    @ForeignKey(name = "fk_store_staff")
    private Staff staff;

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", lastUpdate=" + lastUpdate +
                ", address=" + address +
                ", staff=" + staff +
                '}';
    }
/*
    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffByManagerStaffId;

    public Staff getStaffByManagerStaffId() {
        return staffByManagerStaffId;
    }
    public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
        this.staffByManagerStaffId = staffByManagerStaffId;
    }*/


}
