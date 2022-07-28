package com.ecommerceapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Ana kategoriden bir ürün
 * id: 1
 * name: Bilgisayar
 * subMenu: 0
 * status: true
 *
 * Alt kategoriden bir ürün
 * id: 2
 * name: Ekran Kartı
 * subMenu: 1
 * status: true
 */

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "Name", length = 50)
    public String name;
    public int subMenu;
    public boolean status;
    @Column(name = "Keyword", length = 160)
    public String keyword;
    @Column(name = "Description", length = 160)
    public String description;

    @OneToMany()
    @JoinColumn(name = "CategoryId")
    public List<Product> productList;

}
