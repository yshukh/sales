package com.check.sales.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "purchaseOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CheckItem> orderItems = new ArrayList<>();

    public PurchaseOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CheckItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<CheckItem> orderItems) {
        this.orderItems = orderItems;
    }
}