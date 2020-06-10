package com.check.sales;

import com.check.sales.dao.InventoryItemDao;
import com.check.sales.entity.InventoryItem;
import com.check.sales.entity.attribute.AmountType;
import com.check.sales.view.InventoryItemSearchable;
import com.check.sales.view.SaleWindow;

import javax.swing.*;

public class App {

    public static InventoryItemSearchable items;

    public static void main(String[] args) {
        InventoryItemDao inventoryItemDao = new InventoryItemDao();
        App.fillInventoryItems(inventoryItemDao);
        items = new InventoryItemSearchable(inventoryItemDao);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SaleWindow saleWindow = new SaleWindow();
            frame.setContentPane(saleWindow.getContainerPane());
            frame.pack();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }

    protected static void fillInventoryItems(final InventoryItemDao inventoryItemDao) {
        InventoryItem coca = new InventoryItem(
                "Coca-Cola",
                "1234567890123",
                10,
                15,
                AmountType.PIECE,
                10.0
        );
        InventoryItem lays = new InventoryItem(
                "Lays",
                "1234567890123",
                20,
                25,
                AmountType.WEIGHT,
                20.0
        );
        inventoryItemDao.save(coca);
        inventoryItemDao.save(lays);
    }
}
