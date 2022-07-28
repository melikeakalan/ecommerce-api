package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "order_details")
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int orderId;
    @Column(name = "Name", length = 150)
    public String name;
    @Column(name = "Image", length = 30)
    public String imageName;
    public float price;
    public float discountPrice;
    public int piece;
    public int productId;
}
