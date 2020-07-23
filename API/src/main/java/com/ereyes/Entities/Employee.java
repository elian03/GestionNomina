package com.ereyes.Entities;

public class Employee {
    private int Id;
    private String Cedula;
    private String Nombre;
    private String Departamento;
    private String Puesto;
    private double SalarioMensual;
    private int NominaID;

    public Employee(String cedula, String nombre, String departamento, String puesto, double salarioMensual, int nominaID) {
        Cedula = cedula;
        Nombre = nombre;
        Departamento = departamento;
        Puesto = puesto;
        SalarioMensual = salarioMensual;
        NominaID = nominaID;
    }

    public Employee(){
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

    public double getSalarioMensual() {
        return SalarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        SalarioMensual = salarioMensual;
    }
    public int getNominaID() {
        return NominaID;
    }

    public void setNominaID(int nominaID) {
        NominaID = nominaID;
    }


}
