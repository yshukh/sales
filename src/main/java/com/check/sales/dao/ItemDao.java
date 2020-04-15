package com.check.sales.dao;

import com.check.sales.entity.Item;
import com.check.sales.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemDao {

    public void save(Item item) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Item> get(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Item", Item.class ).list();
        }
    }
}
