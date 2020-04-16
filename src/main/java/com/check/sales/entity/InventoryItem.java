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

    @Column(length = 13)
    private String barcode;

    @Column(name = "purchase_price")
    private int purchasePrice;

    @Column(name = "retail_price")
    private int retailPrice;

    @Column(name = "amount_type")
    @Convert(converter = AmountTypeAttributeConverter.class)
    private Enum amountType = AmountType.PIECE;

    @Column
    private Double balance = 0.0;

    public InventoryItem() {
    }

    public InventoryItem(String name,
                         String barcode,
                         int purchasePrice,
                         int retailPrice,
                         Enum amountType,
                         Double balance) {
        this.name = name;
        this.barcode = barcode;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.amountType = amountType;
        this.balance = balance;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public Enum getAmountType() {
        return amountType;
    }

    public void setAmountType(Enum amountType) {
        this.amountType = amountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
