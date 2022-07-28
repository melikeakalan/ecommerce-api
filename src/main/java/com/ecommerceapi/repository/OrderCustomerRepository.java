package com.ecommerceapi.repository;

import com.ecommerceapi.entity.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Müşterinin teslimat adresi ve fatura adresini ayrı yönetmeyi sağlar
 */
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer, Integer> {
}
