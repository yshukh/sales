package com.check.sales;

import com.check.sales.dao.GeneralCrudDao;
import com.check.sales.entity.InventoryItem;
import com.check.sales.entity.Sale;
import com.check.sales.entity.SaleItem;
import com.check.sales.entity.attribute.AmountType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaoTest {

    @Test
    public void imitateSale() {
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

        Sale sale = new Sale();

        SaleItem saleItemOne = new SaleItem(sale, coca);
        saleItemOne.setAmount(2);
        SaleItem saleItemTwo = new SaleItem(sale, lays);
        saleItemTwo.setAmount(1);
        List<SaleItem> saleItemList = new ArrayList<>();
        saleItemList.add(saleItemOne);
        saleItemList.add(saleItemTwo);

        sale.setSaleItems(saleItemList);

        GeneralCrudDao<Sale> poDao = new GeneralCrudDao<>(Sale.class);
        poDao.save(sale);

        List<Sale> saleList = poDao.get();
        assertEquals("There should be only 1 sale", 1, saleList.size());

        // TODO implement session manager to support lazy initialization
        Sale testSale = saleList.get(0);
        assertEquals("There should be only 2 items in that single sale", 2, testSale.getSaleItems().size());
    }

}
