package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "Name", length = 150)
    public String orderStatus;  //teslim edildi, kargoya verildi, bekleniyor
    @Column(name = "CargoNumber", length = 30)
    public String cargoNumber;
    public float totalPrice;
    public float totalDiscountPrice;
    public int kdv;    //%8, %18 vs
    @Temporal(TemporalType.DATE)
    public Date orderDate;
    public  int customerId;    //müşterininse müşteriId, değilse 0 gelecek
    public String paymentType; //kredi kartı, havale ile ödeme, kapıda ödeme

    @OneToMany()
    @JoinColumn(name = "OrderId", insertable = true)
    public List<OrderCustomer> orderCustomerList;

    @OneToMany()
    @JoinColumn(name = "OrderId", insertable = true)
    public List<OrderDetail> orderDetailList;

    @ManyToOne
    @JoinColumn(name = "CustomerId", insertable = false, updatable = false)
    public Customer customer;
}
