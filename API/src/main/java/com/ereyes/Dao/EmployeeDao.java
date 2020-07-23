package com.ereyes.Dao;
import com.ereyes.Entities.Employee;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDao {

    public List<Employee> getAllEmployees()
    {

        Connection con = getConnection();
        List<Employee> employees = new ArrayList<Employee>();
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from Empleados";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while(rs.next()){
                    Employee newEmployee = new Employee(
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Departamento"),
                            rs.getString("Puesto"),
                            rs.getDouble("SalarioMensual"),
                            rs.getInt("IdNomina")
                    );
                    newEmployee.setId(rs.getInt("id"));
                    employees.add(newEmployee);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return employees;
        }
    }

    public boolean createEmployee(Employee employee) {
        Employee EmployeeToCheck;
        EmployeeToCheck = getEmployeeByCedula(employee.getCedula());
        if (EmployeeToCheck != null) {
            return false;
        } else {
            String query = "INSERT INTO Empleados VALUES ('" + employee.getCedula() + "','" +
                    employee.getNombre() + "','" +
                    employee.getDepartamento() + "','" +
                    employee.getPuesto() + "'," +
                    employee.getSalarioMensual() + "," +
                    employee.getNominaID() + ")";
            return executeUpdate(query);

        }

    }

    private Connection getConnection() {
        try{
            String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress;database=NominaDB;";
            Connection cnn = DriverManager.getConnection(connectionUrl,
                    "sa","ProdoctivityNovosit");
            return cnn;
        }catch (SQLException ex){

            return null;
        }

    }

    public boolean updateEmployee(Employee employee){
        Employee productToCheck;
        productToCheck = getEmployeeById(employee.getId());
        if(employee != productToCheck){
            String query = "UPDATE Empleados SET Cedula = '"+employee.getCedula()+
                    "', Nombre = '"+ employee.getNombre()+
                    "', Departamento='"+ employee.getDepartamento()+
                    "', puesto='"+ employee.getPuesto()+
                    "', SalarioMensual= "+ employee.getSalarioMensual()+
                    ", IdNomina="+employee.getNominaID()+" WHERE id ="+ employee.getId();
            return executeUpdate(query);
        }else {
            return true;
        }
    }

    private boolean executeUpdate(String query){
        try {
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            int result = state.executeUpdate(query);

            if(result ==1){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Employee getEmployeeById(int id){
        String query = "Select * from Empleados WHERE id ="+ id;
        return getEmployee(query);
    }

    private Employee getEmployeeByName(String name){
        String query = "Select * from Empleados WHERE nombre ='"+ name+"'";
        return getEmployee(query);
    }
    private Employee getEmployeeByCedula(String cedula){
        String query = "Select * from Empleados WHERE Cedula ='"+ cedula +"'";
        return getEmployee(query);
    }
    private Employee getEmployee(String query){
        try {
            Employee employee = null;
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                Employee newEmployee = new Employee(
                        rs.getString("Cedula"),
                        rs.getString("Nombre"),
                        rs.getString("Departamento"),
                        rs.getString("Puesto"),
                        rs.getDouble("SalarioMensual"),
                        rs.getInt ("IdNomina")
                );
                newEmployee.setId(rs.getInt("id"));
                employee = newEmployee;
            }
            return employee;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
