package com.dao.setup;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.model.setup.AccountCategory;
import com.model.setup.AccountSubCategory;

@Component
public class DaoImpAccountSubCategory implements DaoAccountSubCategory {

    String msg = "";
    int row = 1;
	
	@Override
	public List<AccountSubCategory> getAll(String hql) {
        msg = "";
        Session session = model.HibernateUtil.getSession();
        List<AccountSubCategory> list = new ArrayList<>();
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
	public int save(AccountSubCategory obj) {
        Session session = model.HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        msg = "";
        row = 1;
        try {
            session.save(obj);
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
	public int update(AccountSubCategory obj) {
        Session session = model.HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        row = 1;
        msg = "";
        try {
            session.update(obj);
            tr.commit();
        } catch (HibernateException e) {
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
	public int delete(String sql) {
        Session session = model.HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        msg = "";
        row = 0;
        try {
            row = session.createSQLQuery(sql).executeUpdate();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            msg = model.Message.exceptionMsg(e);
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return row;
	}

	@Override
	public List getRecord(String sql) {
        msg = "";
        Session session = model.HibernateUtil.getSession();
        List list = new ArrayList();
        try {
            list = session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
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
	public String getMsg() {
		return msg;
	}

}
