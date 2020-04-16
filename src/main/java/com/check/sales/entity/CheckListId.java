package com.check.sales.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CheckListId implements Serializable {

    private int purchaseOrderId;

    private int inventoryItemId;


    public CheckListId() {
    }

    public CheckListId(int purchaseOrderId, int inventoryItemId) {
        this.purchaseOrderId = purchaseOrderId;
        this.inventoryItemId = inventoryItemId;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }
}
