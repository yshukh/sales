package com.check.sales.dao;

import com.check.sales.entity.InventoryItem;
import com.check.sales.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class InventoryItemDao extends GeneralCrudDao<InventoryItem> {

    public InventoryItemDao() {
        super(InventoryItem.class);
    }

    public List<InventoryItem> getFirstByNamePrefix(int amount, String namePrefix) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<InventoryItem> query =
                    session.createQuery("FROM InventoryItem as ii WHERE ii.name LIKE :name ORDER BY name")
                            .setParameter("name", namePrefix + "%");
            query.setMaxResults(amount);
            return query.list();
        }
    }
}
