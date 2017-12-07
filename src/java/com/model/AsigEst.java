package com.model;

public class AsigEst  implements java.io.Serializable {


     private int id;
     private Asignatura asignatura;
     private Usuarios usuarios;
     private float parcial1;
     private float parcial2;
     private String seguimiento;

    public AsigEst() {
    }

    public AsigEst(int id, Asignatura asignatura, Usuarios usuarios, float parcial1, float parcial2, String seguimiento) {
       this.id = id;
       this.asignatura = asignatura;
       this.usuarios = usuarios;
       this.parcial1 = parcial1;
       this.parcial2 = parcial2;
       this.seguimiento = seguimiento;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public float getParcial1() {
        return this.parcial1;
    }
    
    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }
    public float getParcial2() {
        return this.parcial2;
    }
    
    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }
    public String getSeguimiento() {
        return this.seguimiento;
    }
    
    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }




}


