package com.uniyaz.sakila.core.address.dao;


import com.uniyaz.sakila.core.address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressDao extends JpaRepository<Address,Long> {

}
