package com.practice.inventory.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product_inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id")
    public Integer productId;
    @Column(name="product_name")
    public String productName;
    @Column(name="product_type")
    public String productType;
    @Column(name= "product_price")
    public int productPrice;
    @Column(name= "product_manufacturer")
    public String productManufacturer;

}
