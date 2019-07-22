package com.dao.utility;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.model.utility.Tenant;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;


@Component
public class DaoImpTenant implements DaoTenant {

    String msg = "";
    int row = 1;


    @Override
    public List<Tenant> getAll(String hql) {
        msg = "";
        Session session = model.HibernateUtil.getSession();
        List<Tenant> list = new ArrayList<>();
        try {
            list = session.createQuery(hql).list();
        } catch (HibernateException e) {
            msg = model.Message.exceptionMsg(e);
        }
        try {
            session.close();
        } catch (HibernateException e) {
        }
        return list;
    }

    @Override
    public int save(Tenant obj) {
        Session session = model.HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        msg = "";
        row = 1;
        try {
            session.saveOrUpdate(obj);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            msg = model.Message.exceptionMsg(e);
            row = 0;
        }
        try {
            session.close();
        } catch (HibernateException e) {
        }
        return row;
    }


    @Override
    public String getMsg() {
        return msg;
    }

}
