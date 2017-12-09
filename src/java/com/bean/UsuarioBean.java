package com.bean;

import com.dao.UsuarioDAO;
import com.model.AsigEst;
import com.model.Asignatura;
import com.model.Roles;
import com.model.Usuarios;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Integer idUsuario;
    private Roles roles;
    private String email;
    private String password;
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String carrera;
    private Set<AsigEst> asigEsts = new HashSet<AsigEst>(0);
    private Asignatura asignatura;
    
    public void returnUserLogin() throws IOException{
        ExternalContext context = 
                FacesContext.getCurrentInstance().getExternalContext();
        UsuarioDAO userDao = new UsuarioDAO();
        Usuarios user = userDao.getUserLogin(getEmail(), getPassword());
        if(user != null){
            setIdUsuario(user.getIdUsuario());
            setNombre(user.getNombre());
            Roles rol = user.getRoles();
            if(rol.getIdRol() == 1){
                context.redirect("asignaturas.xhtml");
            }else if(rol.getIdRol() == 2){
                context.redirect("notas-estudiante.xhtml");
            }
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Datos incorrectos"));
        }
    }
    
    public void returnLogout() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Se ha cerrado sesión"));
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the roles
     */
    public Roles getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
    
}
