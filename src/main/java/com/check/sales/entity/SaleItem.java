package com.check.sales.entity;

import javax.persistence.*;

@Entity
@Table(name = "sale_item")
public class SaleItem {

    @EmbeddedId
    private CashVoucherId cashVoucherId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    @MapsId("saleId")
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
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
        this.cashVoucherId = new CashVoucherId(sale.getId(), inventoryItem.getId());
    }

    public CashVoucherId getCashVoucherId() {
        return cashVoucherId;
    }

    public void setCashVoucherId(CashVoucherId cashVoucherId) {
        this.cashVoucherId = cashVoucherId;
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
