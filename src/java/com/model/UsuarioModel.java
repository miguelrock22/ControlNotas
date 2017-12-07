package com.model;

import com.data.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UsuarioModel {
    
    public void Login(String email, String password){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControlNotasPU");
            EntityManager em = emf.createEntityManager();
            /*TypedQuery<Usuarios> query = em.createNamedQuery("Usuario.findByEmailPass", Usuarios.class)
                    .setParameter("email", "test@test.com")
                    .setParameter("password", "123456");
            List<Usuarios> results = query.getResultList();
            System.out.println(results);*/
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        UsuarioModel us = new UsuarioModel();
        us.Login("test@test.com","123456");
    }
}
