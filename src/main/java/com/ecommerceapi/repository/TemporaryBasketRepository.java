package com.ecommerceapi.repository;

import com.ecommerceapi.entity.Order;
import com.ecommerceapi.entity.TemporaryBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemporaryBasketRepository extends JpaRepository<TemporaryBasket, Integer> {

    @Query(value = "SELECT * FROM TemporaryBasket WHERE cookieBasketId = :cookieId LIMIT 1", nativeQuery = true)
    public TemporaryBasket basketCookieControl(@Param("cookieId") int cookieId);

    @Query(value = "Select * FROM Order Where id = :cookieId LIMIT 1",nativeQuery = true)
    public Order orderCookieControl(@Param("cookieId") int cookieId);

    @Query(value = "Select * FROM TemporaryBasket WHERE cookieBasketId = :cookieId",nativeQuery = true)
    public List<TemporaryBasket> getAllList(@Param("cookieId") int cookieId);

    @Query(value = "SELECT * FROM TemporaryBasket WHERE id = :basketId",nativeQuery = true)
    public TemporaryBasket sepetAdetKontrol(@Param("basketId") int basketId);

}
