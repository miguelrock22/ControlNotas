
package com.dao;

import com.model.Asignatura;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AsignaturaDAO {
    private Session session = null;
    private List<Asignatura> asignaturas = null;
    
    public List<Asignatura> getAsignaturas(int id){
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "FROM Asignatura WHERE userId = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            asignaturas = (List<Asignatura>)query.list();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return asignaturas;
    }
    
    public Asignatura getAsigById(int id){
        Asignatura asig = null;
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Asignatura where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            asig = (Asignatura) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return asig;
    }
}
