package model;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DB {

    String msg;

    public int save(String sql) {
        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        int a = 0;
        try {
            a = session.createSQLQuery(sql).executeUpdate();
            tr.commit();
            setMsg("Success");
        } catch (Exception e) {
            setMsg(model.Message.exceptionMsg(e));
            tr.rollback();
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return a;
    }

    public int save(String sql, String[] parameterValue) {
        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        int a = 0;
        try {
            Query query = session.createSQLQuery(sql);
            for (int i = 0; i < parameterValue.length; i++) {
                query.setParameter(i, parameterValue[i]);
            }
            a = query.executeUpdate();
            tr.commit();
            setMsg("Success");
        } catch (Exception e) {
            setMsg(model.Message.exceptionMsg(e));
            tr.rollback();
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return a;
    }

    public int save(String sql, String[] parameter, String[] parameterValue) {
        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        int a = 0;
        try {
            Query query = session.createSQLQuery(sql);
            for (int i = 0; i < parameter.length; i++) {
                query.setParameter(parameter[i], parameterValue[i]);
            }
            a = query.executeUpdate();
            tr.commit();
            setMsg("Success");
        } catch (Exception e) {
            setMsg(model.Message.exceptionMsg(e));
            tr.rollback();
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return a;
    }

    public int delete(String sql) {
        int a = 0;
        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();
        try {
            a = session.createSQLQuery(sql).executeUpdate();
            tr.commit();
            setMsg("Success");
        } catch (Exception e) {
            setMsg(model.Message.exceptionMsg(e));
            tr.rollback();
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return a;
    }

    public List getRecord(String sql) {
        Session session = HibernateUtil.getSession();    
        try {
            List list = session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
         session.close();
         return list;
        } catch (Exception e) {
            msg = model.Message.exceptionMsg(e);
        }
        try {
            session.close();
        } catch (Exception e) {
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
