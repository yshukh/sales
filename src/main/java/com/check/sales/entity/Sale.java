package com.check.sales.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "sale",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SaleItem> saleItems = new ArrayList<>();

    @Column(name = "sale_date")
    @CreationTimestamp
    private Date saleDate;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }
}