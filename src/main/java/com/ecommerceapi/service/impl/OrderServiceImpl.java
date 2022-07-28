package com.ecommerceapi.service.impl;

import com.ecommerceapi.entity.Order;
import com.ecommerceapi.entity.Product;
import com.ecommerceapi.repository.OrderRepository;
import com.ecommerceapi.repository.ProductRepository;
import com.ecommerceapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public String add(Order data) {
        try
        {
            orderRepository.saveAll(List.of(data));

            data.orderDetailList.forEach((e)-> {
                Product product = productRepository.findById(e.productId).orElse(null); // Satın alınan ürünü depoda buluyor.
                product.stock -= e.piece; // Satın alınan ürün'ün adeti, Depodaki Ürün'ün adetinden düşürülüyor.
                productRepository.save(product);
            });

            return "İşlem Başarlı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public List<Order> customerGetAll(int customerId) {

        List<Order> datalar = new ArrayList<>();
        for (Order order : orderRepository.findAll())
        {
            if(order.customerId == customerId)
            {
                datalar.add(order);
            }
        }
        return datalar;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public String update(Order data) {
        try
        {
            orderRepository.saveAll(List.of(data));
            return "İşlem Başarılı Bir Şekilde Gerçekleşti";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

}
