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
}
