package com.ereyes.Dao;

import com.ereyes.Entities.TransactionLog;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class TransactionLogDao {
    public List<TransactionLog> getAllEmploees()
    {

        Connection con = getConnection();
        List<TransactionLog> TransactionLogs = new ArrayList<TransactionLog>();
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from RegistroTansaccion";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);
                while(rs.next()){
                    TransactionLog newTransactionLog = new TransactionLog(
                            rs.getInt("IdEmpleado"),
                            rs.getInt("IdIngreso"),
                            rs.getInt("IdDeduccion"),
                            rs.getString("Tipotransaccion"),
                            rs.getDate("Fecha"),
                            rs.getDouble("Monto"),
                            rs.getString("Estado")
                    );
                    newTransactionLog.setId(rs.getInt("id"));
                    TransactionLogs.add(newTransactionLog);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return TransactionLogs;
        }
    }

    public boolean createTransactionLog(TransactionLog transactionLog) {
        if (transactionLog.getIdIngreso() ==0)
        {
            transactionLog.setTipotransaccion("Credito");

        }else {transactionLog.setTipotransaccion("Debito");}

            String query = "INSERT INTO RegistroTansaccion VALUES (" + transactionLog.getIdEmpleado() + "," +
                    transactionLog.getIdDeduccion() + "," +
                    transactionLog.getIdIngreso() + ",'" +
                    transactionLog.getTipotransaccion() + "'," +
                    Date.from(Instant.now()) + "," +
                    transactionLog.getMonto() + ",'" +
                    transactionLog.getEstado() + "')";
            return executeUpdate(query);



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

    private TransactionLog getTransactionLogBy_Id(int id){
        String query = "Select * from RegistroTansaccion WHERE id ="+ id;
        return getTransactionLog(query);
    }


    private TransactionLog getTransactionLog(String query){
        try {
            TransactionLog transactionLog = new TransactionLog();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                TransactionLog newTransactionLog = new TransactionLog(
                        rs.getInt("IdEmpleado"),
                        rs.getInt("IdIngreso"),
                        rs.getInt("IdDeduccion"),
                        rs.getString("Tipotransaccion"),
                        rs.getDate("Fecha"),
                        rs.getDouble("Monto"),
                        rs.getString("Estado")
                );
                newTransactionLog.setId(rs.getInt("id"));
                transactionLog = newTransactionLog;
            }
            return transactionLog;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
