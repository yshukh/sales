package com.check.sales.view;

import com.check.sales.entity.InventoryItem;

import javax.swing.*;

public class ItemToPickCheckBoxModel extends DefaultComboBoxModel<InventoryItem> {

    public ItemToPickCheckBoxModel(InventoryItem[] items) {
        super(items);
    }

    @Override
    public InventoryItem getSelectedItem() {
        return (InventoryItem) super.getSelectedItem();
    }

}
