package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "Name", length = 150)
    public String name;
    @Column(name = "ImageName", length = 30)
    public String imageName;
    public String explanation;
    public float price;
    public float discountPrice;
    public int stock;
    public boolean status;
    public int categoryId;
    @Column(name = "Keyword", length = 160)
    public String keyword;
    @Column(name = "Description", length = 160)
    public String description;

}
