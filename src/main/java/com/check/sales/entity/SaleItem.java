package com.check.sales.entity;

import javax.persistence.*;

@Entity
@Table(name = "sale_item")
public class SaleItem {

    @EmbeddedId
    private SaleItemId saleItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sale_id")
    @MapsId("saleId")
    private Sale sale;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory_item_id")
    @MapsId("inventoryItemId")
    private InventoryItem inventoryItem;

    @Column(name = "amount")
    private int amount;

    public SaleItem() {
    }

    public SaleItem(Sale sale, InventoryItem inventoryItem) {
        this.sale = sale;
        this.inventoryItem = inventoryItem;
        this.saleItemId = new SaleItemId(sale.getId(), inventoryItem.getId());
    }

    public SaleItemId getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(SaleItemId saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
