package com.uniyaz.sakila.core.customer.dao;

import com.uniyaz.sakila.core.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
}
