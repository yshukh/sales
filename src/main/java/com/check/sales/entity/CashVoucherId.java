package com.check.sales.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CashVoucherId implements Serializable {

    private int saleId;

    private int inventoryItemId;

    public CashVoucherId() {
    }

    public CashVoucherId(int saleId, int inventoryItemId) {
        this.saleId = saleId;
        this.inventoryItemId = inventoryItemId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }
}
