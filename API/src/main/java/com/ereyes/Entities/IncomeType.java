package com.ereyes.Entities;

public class IncomeType {

    private int Id;
	private String Nombre;
	private String DependeSalario;
	private String Estado;

	public IncomeType(String nombre,String dependeSalario, String estado){

        Nombre= nombre;
        DependeSalario=dependeSalario;
        Estado=estado;
    }
    public IncomeType(){}

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

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
