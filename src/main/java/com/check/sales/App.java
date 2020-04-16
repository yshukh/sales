package com.check.sales;

import com.check.sales.dao.GeneralCrudDao;
import com.check.sales.entity.CheckItem;
import com.check.sales.entity.InventoryItem;
import com.check.sales.entity.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        TODO amount of item where to save?
        InventoryItem coca = new InventoryItem("Coca-Cola", 10, 15);
        InventoryItem lays = new InventoryItem("Lays", 20, 25);

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        CheckItem checkItemOne = new CheckItem(purchaseOrder, coca);
        checkItemOne.setAmount(2);
        CheckItem checkItemTwo = new CheckItem(purchaseOrder, lays);
        checkItemTwo.setAmount(1);
        List<CheckItem> checkItemList = new ArrayList<>();
        checkItemList.add(checkItemOne);
        checkItemList.add(checkItemTwo);

        purchaseOrder.setOrderItems(checkItemList);

        GeneralCrudDao<PurchaseOrder> poDao = new GeneralCrudDao<>(PurchaseOrder.class);
        poDao.save(purchaseOrder);
    }
}
