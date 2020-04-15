package com.check.sales;

import com.check.sales.dao.PurchaseOrderDao;
import com.check.sales.entity.Item;
import com.check.sales.entity.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        PurchaseOrderDao purchaseOrderDao = new PurchaseOrderDao();
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        List<Item> items = new ArrayList<>();
        Item itemOne = new Item("Lays", 1, 25);
        Item itemTwo = new Item("Coca-cola", 1, 20);
        items.add(itemOne);
        items.add(itemTwo);

        purchaseOrder.setItems(items);

        purchaseOrderDao.save(purchaseOrder);

        List<PurchaseOrder> purchaseOrders = purchaseOrderDao.get();
        purchaseOrders.forEach(curPurchaseOrder -> {
            System.out.println(curPurchaseOrder.toString());
        });
    }
}
