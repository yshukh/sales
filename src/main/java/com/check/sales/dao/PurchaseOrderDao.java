package com.check.sales.dao;

import com.check.sales.entity.PurchaseOrder;
import com.check.sales.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PurchaseOrderDao {
    public void save(PurchaseOrder purchaseOrder) {
        Transaction trans = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trans = session.beginTransaction();
            session.save(purchaseOrder);
            trans.commit();
        } catch (Exception ex) {
            if (trans != null) {
                trans.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<PurchaseOrder> get(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from PurchaseOrder", PurchaseOrder.class ).list();
        }
    }

}
