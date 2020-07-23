package com.ereyes.Dao;

import com.ereyes.Entities.DeductionType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DeductionTypeDao {
    public List<DeductionType> getAllDeductionTypes()
    {

        Connection con = getConnection();
        List<DeductionType> DeductionTypes = new ArrayList<DeductionType>();
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from TiposDeducciones";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while(rs.next()){
                    DeductionType newDeductionType= new DeductionType(rs.getString("Nombre"),rs.getString("DependeSalario"),rs.getString("Estado"));
                    newDeductionType.setId(rs.getInt("id"));
                    DeductionTypes.add(newDeductionType);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return DeductionTypes;
        }
    }

    public boolean createDeductionType(DeductionType deductionType) {
        DeductionType deductionTypesToCheck;
        deductionTypesToCheck = getDeductionTypeByName(deductionType.getNombre());
        if (deductionTypesToCheck != null) {
            return false;
        } else {
            String query = "INSERT INTO TiposDeducciones VALUES ('" + deductionType.getNombre() + "','" +
                    deductionType.getDependeSalario() + "','" +
                    deductionType.getEstado() + "')";
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
    public boolean updateDeductionType(DeductionType DeductionType){
        DeductionType ImcomeToCheck;
        ImcomeToCheck = getDeductionTypeBy_Id(DeductionType.getId());
        if(DeductionType != ImcomeToCheck){
            String query = "UPDATE TiposDeducciones SET Nombre = '"+DeductionType.getNombre()+
                    "', DependeSalario = '"+ DeductionType.getDependeSalario()+
                    "', Estado='"+DeductionType.getEstado()+"' WHERE id ="+ DeductionType.getId();
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

    private DeductionType getDeductionTypeBy_Id(int id){
        String query = "Select * from TiposDeducciones WHERE id ="+ id;
        return getDeductionType(query);
    }

    private DeductionType getDeductionTypeByName(String name){
        String query = "Select * from TiposDeducciones WHERE Nombre ="+ name;
        return getDeductionType(query);
    }

    private DeductionType getDeductionType(String query){
        try {
            DeductionType deductionType = new DeductionType();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                DeductionType newDeductionType = new DeductionType(
                        rs.getString("Nomrbe"),
                        rs.getString("DependeSalario"),
                        rs.getString("Estado")
                );
                newDeductionType.setId(rs.getInt("id"));
                deductionType = newDeductionType;
            }
            return deductionType;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
