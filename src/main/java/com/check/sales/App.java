package com.check.sales;

import com.check.sales.dao.GeneralCrudDao;
import com.check.sales.entity.InventoryItem;
import com.check.sales.entity.attribute.AmountType;
import com.check.sales.view.SaleWindow;
import com.check.sales.view.StringSearchable;

import javax.swing.*;
import java.util.stream.Collectors;

public class App {

    public static StringSearchable items;
    //TODO add InventoryItemDto and map it to the combobox searching machine
    public static void main(String[] args) {
        GeneralCrudDao<InventoryItem> saleItemDao = new GeneralCrudDao<>(InventoryItem.class);
        App.fillInventoryItems(saleItemDao);
        items = new StringSearchable(
                saleItemDao.get().stream()
                        .map(InventoryItem::getName)
                        .collect(Collectors.toList())
        );
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

    protected static void fillInventoryItems(final GeneralCrudDao<InventoryItem> saleItemDao) {
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
        saleItemDao.save(coca);
        saleItemDao.save(lays);
    }
}
