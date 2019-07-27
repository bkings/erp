package com.dao.account;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.model.account.BalanceSheet;
import com.model.account.GeneralJournals;

import model.HibernateUtil;
import model.Message;

@Component
public class DaoImpGeneralJournals implements DaoGeneralJournals {

	String msg = "";
	int row = 1;

	@Override
	public List<GeneralJournals> getAll(String hql) {

		msg = "";
		Session session = HibernateUtil.getSession();

		List<GeneralJournals> list = new ArrayList<>();

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

		return list;
	}

	@Override
	public int save(GeneralJournals obj) {

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
	public int update(GeneralJournals obj) {

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

		Session session = HibernateUtil.getSession();
		msg="";
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
		return null;
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return null;
	}

}
