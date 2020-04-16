package com.check.sales.entity;

import javax.persistence.*;

@Entity
@Table(name = "check_item")
public class CheckItem {

    @EmbeddedId
    private CheckListId checkListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    @MapsId("purchaseOrderId")
    private PurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_item_id")
    @MapsId("inventoryItemId")
    private InventoryItem inventoryItem;

    @Column(name = "amount")
    private int amount;

    public CheckItem() {
    }

    public CheckItem(PurchaseOrder purchaseOrder, InventoryItem inventoryItem) {
        this.purchaseOrder = purchaseOrder;
        this.inventoryItem = inventoryItem;
        this.checkListId = new CheckListId(purchaseOrder.getId(), inventoryItem.getId());
    }

    public CheckListId getCheckListId() {
        return checkListId;
    }

    public void setCheckListId(CheckListId checkListId) {
        this.checkListId = checkListId;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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
