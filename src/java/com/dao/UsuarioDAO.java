package com.dao;

import com.model.Usuarios;
import com.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    
    private Session session = null;
    private List<Usuarios> users = null;
    
    /**
     * Login Method
     * @param email
     * @param password
     * @return Usuarios
     */
    public Usuarios getUserLogin(String email, String password){
        Usuarios user = null;
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Usuarios where email = :email AND password = :password";
            Query query = session.createQuery(queryString);
            query.setString("email", email);
            query.setString("password", password);
            user = (Usuarios) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return user;
    }
    /**
     * Get User by id
     * @param id
     * @return Usuarios
     */
    public Usuarios getUserById(int id){
        Usuarios user = null;
        Transaction trns = null;
        session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Usuarios where id_usuario = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            user = (Usuarios) query.uniqueResult();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
            session.flush();
            session.close();
        }
        return user;
    }
}
