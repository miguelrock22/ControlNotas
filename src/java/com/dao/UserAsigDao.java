package com.dao;

import com.model.AsigEst;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserAsigDao {
    
    private Session session = null;
    private List<AsigEst> estudents = null;
    
    public List<AsigEst> getEstByAsig(int asig_id){
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "FROM AsigEst WHERE asignatura = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", asig_id);
            estudents = (List<AsigEst>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return estudents;
    }
    
    public List<AsigEst> getEstByUser(int user_id){
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "FROM AsigEst WHERE usuarios = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", user_id);
            estudents = (List<AsigEst>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return estudents;
    }
    
    public AsigEst getAsigEstById(int id){
        AsigEst notes = null; 
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "FROM AsigEst WHERE id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            notes = (AsigEst)query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return notes;
    }
    
    public boolean updateNota(AsigEst nota) {
        boolean ret = true;
        Transaction trns = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(nota);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            ret = false;
        } finally {
            session.flush();
            session.close();
        }
        return ret;
    }
}
