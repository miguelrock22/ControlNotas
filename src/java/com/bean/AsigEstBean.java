package com.bean;

import com.dao.UserAsigDao;
import com.model.AsigEst;
import com.model.Asignatura;
import com.model.Usuarios;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Named(value = "asigEstBean")
@ViewScoped
@ManagedBean

public class AsigEstBean implements Serializable {

    private int id;
    private Asignatura asignatura;
    private Usuarios usuarios;
    private float parcial1;
    private float parcial2;
    private String seguimiento;
   
    public AsigEstBean() {
    }
    
    /**
     * Get asignaturas by user id
     * @param id asignatura id
     * @return List<AsigEst> 
     */
    public List<AsigEst> returnAsigUser(int id){
        UserAsigDao asigDao = new UserAsigDao();
        List<AsigEst> asig = asigDao.getEstByAsig(id);
        return asig;
    }
    
    /**
     * Get asig_user row by his id
     * @param id asigEst id
     * @return AsigEst 
     */
    public AsigEst returnAsigUserById(int id){
        UserAsigDao asigDao = new UserAsigDao();
        AsigEst asig = asigDao.getAsigEstById(id);
        return asig;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the asignatura
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * @param asignatura the asignatura to set
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * @return the usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the parcial1
     */
    public float getParcial1() {
        return parcial1;
    }

    /**
     * @param parcial1 the parcial1 to set
     */
    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }

    /**
     * @return the parcial2
     */
    public float getParcial2() {
        return parcial2;
    }

    /**
     * @param parcial2 the parcial2 to set
     */
    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }

    /**
     * @return the seguimiento
     */
    public String getSeguimiento() {
        return seguimiento;
    }

    /**
     * @param seguimiento the seguimiento to set
     */
    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }
    
}
