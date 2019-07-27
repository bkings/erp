package com.dao.account;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.model.account.BalanceSheet;

import model.HibernateUtil;
import model.Message;

@Component
public class DaoImpBalanceSheet implements DaoBalanceSheet {

	String msg = "";
	int row = 1;

	@Override
	public List<BalanceSheet> getAll(String hql) {

		System.out.println("inside dao getall");
		msg = "";
		Session session = HibernateUtil.getSession();

		List<BalanceSheet> list = new ArrayList<>();

		System.out.println("inside dao getall 2");

		try {
			System.out.println("inside dao getall 3");
			list = session.createQuery(hql).list();
			System.out.println("inside dao getall 4");
		} catch (HibernateException e) {
			msg = Message.exceptionMsg(e);
		}
		try {
			session.close();
		} catch (HibernateException e) {
		}

		for (BalanceSheet myList : list) {
			System.out.println("From the table it is yes \n" + myList.getNumber());
		}

		return list;
	}

	@Override
	public int save(BalanceSheet obj) {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		msg = "";
		row = 1;
		try {
			session.save(obj);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			msg = Message.exceptionMsg(e);
			row = 0;
		}
		try {
			session.close();
		} catch (HibernateException e) {
		}
		return row;
	}

	@Override
	public int update(BalanceSheet obj) {
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		row = 1;
		msg = "";
		try {
			session.update(obj);
			tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
			msg = Message.exceptionMsg(e);
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
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		msg = "";
		row = 0;

		try {
			row = session.createSQLQuery(sql).executeUpdate();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			msg = Message.exceptionMsg(e);
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
		Session session = HibernateUtil.getSession();
		List list = new ArrayList<>();

		try {
			list = session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
		} catch (HibernateException e) {
			msg = Message.exceptionMsg(e);
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
