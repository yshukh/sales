package com.check.sales.entity;

import com.check.sales.entity.attribute.AmountType;
import com.check.sales.entity.converter.AmountTypeAttributeConverter;

import javax.persistence.*;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "purchase_price")
    private int purchasePrice;

    @Column(name = "retail_price")
    private int retailPrice;

    @Column(name = "amount_type")
    @Convert(converter = AmountTypeAttributeConverter.class)
    private Enum amountType = AmountType.PIECE;

    @Column
    private Double balance = 0.0;

    public InventoryItem(String name, int purchasePrice, int retailPrice) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }
}
