package com.bean;

//import com.model.Usuarios;
import javax.inject.Named;
import java.io.Serializable;
import com.dao.AsignaturaDAO;
import com.model.AsigEst;
import com.model.Asignatura;
import com.model.Usuarios;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Named(value = "asignaturaBean")
@ViewScoped
@ManagedBean
public class AsignaturaBean implements Serializable {
    private int id;
    private Usuarios usuarios;
    private String nombre;
    private String cod;
    private Integer userId;
    private Set<AsigEst> asigEsts = new HashSet<AsigEst>(0);
    /**
     * Creates a new instance of AsignaturaBean
     */
    public AsignaturaBean() {
        
    }

    public List<Asignatura> returnAsignaturas(int id){
        AsignaturaDAO asigDao = new AsignaturaDAO();
        List<Asignatura> asig = asigDao.getAsignaturas(id);
        return asig;
    }
    
    public Asignatura returnAsignaturaById(int id){
        AsignaturaDAO asigDao = new AsignaturaDAO();
        Asignatura asig = asigDao.getAsigById(id);
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the asigEsts
     */
    public Set<AsigEst> getAsigEsts() {
        return asigEsts;
    }

    /**
     * @param asigEsts the asigEsts to set
     */
    public void setAsigEsts(Set<AsigEst> asigEsts) {
        this.asigEsts = asigEsts;
    }
    
}
