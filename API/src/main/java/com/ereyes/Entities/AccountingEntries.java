package com.ereyes.Entities;

import java.awt.*;
import java.util.Date;

public class AccountingEntries {
   private  int Id;
    private  int IdEmpleado;
    private  String Descripcion;
    private  String Cuenta;
    private  String TipoMovimiento;
    private Date FechaAsiento;
    private  double MontoAsiento;
    private String Estado;

    public AccountingEntries(int idEmpleado, String descripcion, String cuenta, String tipoMovimiento, Date fechaAsiento, double montoAsiento, String estado ){
       IdEmpleado = idEmpleado;
       Descripcion = descripcion;
       Cuenta =cuenta;
       TipoMovimiento =tipoMovimiento;
       FechaAsiento =fechaAsiento;
       MontoAsiento = montoAsiento;
       Estado = estado;
    }
    public AccountingEntries(){}

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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String cuenta) {
        Cuenta = cuenta;
    }
    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        TipoMovimiento = tipoMovimiento;
    }

    public Date getFechaAsiento() {
        return FechaAsiento;
    }

    public void setFechaAsiento(Date fechaAsiento) {
        FechaAsiento = fechaAsiento;
    }

    public double getMontoAsiento() {
        return MontoAsiento;
    }

    public void setMontoAsiento(double montoAsiento) {
        MontoAsiento = montoAsiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

}
