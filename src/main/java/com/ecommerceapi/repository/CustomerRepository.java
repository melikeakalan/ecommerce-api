package com.ecommerceapi.repository;

import com.ecommerceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customers WHERE email = :email AND password = :password  LIMIT 1", nativeQuery = true)
    public Customer login(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM customers where email = :email OR phone = :phone LIMIT 1",nativeQuery = true)
    public Customer customerControl(@Param("email") String email, @Param("phone") String phone);


}
