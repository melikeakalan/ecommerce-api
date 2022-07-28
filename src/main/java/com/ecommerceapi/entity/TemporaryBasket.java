package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "temporary_baskets")
@Entity
public class TemporaryBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "Name", length = 150)
    public String name;

    @Column(name = "ImageName", length = 30)
    public String imageName;

    public float price;
    public float discountPrice;
    public int piece;           //products tablosundaki stok yerine burada adet tutulur
    public int cookieBasketId;  //her kullanıcıya özel üretilir
    public int productId;       //sepetteki ürünün ürünId'si



}

