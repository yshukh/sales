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
                "1234567890120",
                10,
                15,
                AmountType.PIECE,
                10.0
        );

        InventoryItem lays = new InventoryItem(
                "Lays",
                "1234567890121",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        InventoryItem chickenFillet = new InventoryItem(
                "Chicken fillet",
                "1234567890122",
                20,
                25,
                AmountType.WEIGHT,
                20.0
        );

        InventoryItem trout = new InventoryItem(
                "Trout",
                "1234567890123",
                20,
                25,
                AmountType.WEIGHT,
                20.0
        );

        InventoryItem potato = new InventoryItem(
                "Potato",
                "1234567890124",
                20,
                25,
                AmountType.WEIGHT,
                20.0
        );

        InventoryItem rice = new InventoryItem(
                "Rice",
                "1234567890125",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        InventoryItem carpathianSpring = new InventoryItem(
                "Carpathian spring",
                "1234567890126",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        InventoryItem hennessy = new InventoryItem(
                "Hennessy X.O",
                "1234567890127",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        InventoryItem ham = new InventoryItem(
                "Pork ham",
                "1234567890128",
                20,
                25,
                AmountType.WEIGHT,
                20.0
        );

        InventoryItem chocolate = new InventoryItem(
                "J.D. Gross dark chocolate 95% cacao",
                "1234567890129",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        InventoryItem corn = new InventoryItem(
                "Canned kernel corn",
                "1234567890130",
                20,
                25,
                AmountType.PIECE,
                20.0
        );

        inventoryItemDao.save(chickenFillet);
        inventoryItemDao.save(trout);
        inventoryItemDao.save(potato);
        inventoryItemDao.save(rice);
        inventoryItemDao.save(carpathianSpring);
        inventoryItemDao.save(hennessy);
        inventoryItemDao.save(ham);
        inventoryItemDao.save(chocolate);
        inventoryItemDao.save(corn);
        inventoryItemDao.save(coca);
        inventoryItemDao.save(lays);
    }
}
