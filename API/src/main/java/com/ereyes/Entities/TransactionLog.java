package com.ereyes.Entities;
import java.util.Date;
import java.util.EmptyStackException;

public class TransactionLog {
    private	int Id;
    private int IdEmpleado;
    private int IdIngreso;
    private int IdDeduccion;
    private String Tipotransaccion;
    private Date Fecha;
    private double Monto;
    private String Estado;

    public TransactionLog(int idEmpleado,int idIngreso,int idDeduccion,String tipotransaccion,Date fecha,double monto,String estado){

        IdEmpleado = idEmpleado;
        IdIngreso = idIngreso;
        IdDeduccion = idDeduccion;
        Tipotransaccion = tipotransaccion;
        Fecha = fecha;
        Monto = monto;
        Estado = estado;

    }

    public TransactionLog(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public int getIdIngreso() {
        return IdIngreso;
    }
    public void setIdIngreso(int idIngreso) {
        IdIngreso = idIngreso;
    }

    public int getIdDeduccion() {
        return IdDeduccion;
    }
    public void setIdDeduccion(int idDeduccion) {
        IdDeduccion = idDeduccion;
    }

    public String getTipotransaccion() {
        return Tipotransaccion;
    }
    public void setTipotransaccion(String tipotransaccion) {
        Tipotransaccion = tipotransaccion;
    }

    public Date getFecha() {
        return Fecha;
    }
    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public double getMonto() {
        return Monto;
    }
    public void setMonto(double monto) {
        Monto = monto;
    }

    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }

}

