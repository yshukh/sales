package com.check.sales.view;

import com.check.sales.dao.InventoryItemDao;
import com.check.sales.dto.InventoryItemDto;
import com.check.sales.entity.InventoryItem;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryItemSearchable implements Searchable<InventoryItemDto, String> {

    private InventoryItemDao inventoryItemDao;

    public InventoryItemSearchable(InventoryItemDao inventoryItemDao) {
        this.inventoryItemDao = inventoryItemDao;
    }

    @Override
    public Collection<InventoryItemDto> search(String value) {

        List<InventoryItem> items = inventoryItemDao.getFirstByNamePrefix(10, value);
        return items.stream()
                .map((item) -> new InventoryItemDto(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }
}
