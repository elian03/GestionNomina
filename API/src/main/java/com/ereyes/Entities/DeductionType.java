package com.ereyes.Entities;

public class DeductionType {

    private int Id;
    private String Nombre;
    private String DependeSalario;
    private String Estado;

    public DeductionType(String nombre,String dependeSalario, String estado){

        Nombre= nombre;
        DependeSalario=dependeSalario;
        Estado=estado;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public DeductionType(){}
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDependeSalario() {
        return DependeSalario;
    }

    public void setDependeSalario(String dependeSalario) {
        DependeSalario = dependeSalario;
    }
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
