package com.ecommerceapi.service;

import com.ecommerceapi.entity.TemporaryBasket;

import java.util.List;

public interface TemporaryBasketService {

    public String add(TemporaryBasket data);

    public List<TemporaryBasket> getAll(int cookieId);

    public TemporaryBasket getById(int id);

    public String delete(int id);

    public String update(int basketId,boolean status);
}
