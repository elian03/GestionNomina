package com.ereyes.Dao;

import com.ereyes.Entities.IncomeType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IncomeTypeDao {

    public List<IncomeType> getAllIncomeTypes()
    {

        Connection con = getConnection();
        List<IncomeType> incomeTypes = new ArrayList<IncomeType>();
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from TipoIngreso";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while(rs.next()){
                    IncomeType newIncomeType= new IncomeType(rs.getString("Nombre"),rs.getString("DependeSalario"),rs.getString("Estado"));
                    newIncomeType.setId(rs.getInt("id"));
                    incomeTypes.add(newIncomeType);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return incomeTypes;
        }
    }

    public boolean createIncomeType(IncomeType incomeType) {
        IncomeType incomeTypesToCheck;
        incomeTypesToCheck = getIncomeTypeByName(incomeType.getNombre());
        if (incomeTypesToCheck != null) {
            return false;
        } else {
            String query = "INSERT INTO TipoIngreso VALUES ('" + incomeType.getNombre() + "','" +
                    incomeType.getDependeSalario() + "','" +
                    incomeType.getEstado() + "')";
            return executeUpdate(query);

        }

    }

    private Connection getConnection() {
        try{
            String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress;database=nominaDB;";
            Connection cnn = DriverManager.getConnection(connectionUrl,
                    "sa","ProdoctivityNovosit");
            return cnn;
        }catch (SQLException ex){

            return null;
        }

    }
    public boolean updateIncomeTypes(IncomeType incomeType){
        IncomeType ImcomeToCheck;
        ImcomeToCheck = getIncomeTypeBy_Id(incomeType.getId());
        if(incomeType != ImcomeToCheck){
            String query = "UPDATE TipoIngreso SET Nombre = '"+incomeType.getNombre()+
                    "', DependeSalario = '"+ incomeType.getDependeSalario()+
                    "', Estado='"+incomeType.getEstado()+"' WHERE id ="+ incomeType.getId();
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

    private IncomeType getIncomeTypeBy_Id(int id){
        String query = "Select * from TipoIngreso WHERE id ="+ id;
        return getIncomeType(query);
    }

    private IncomeType getIncomeTypeByName(String name){
        String query = "Select * from TipoIngreso WHERE nombre ="+ name;
        return getIncomeType(query);
    }

    private IncomeType getIncomeType(String query){
        try {
            IncomeType IncomeType = new IncomeType();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                IncomeType newIncomeType = new IncomeType(
                        rs.getString("Nomrbe"),
                        rs.getString("DependeSalario"),
                        rs.getString("Estado")
                );
                newIncomeType.setId(rs.getInt("id"));
                IncomeType = newIncomeType;
            }
            return IncomeType;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
