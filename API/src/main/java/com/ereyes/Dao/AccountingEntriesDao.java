package com.ereyes.Dao;

import com.ereyes.Entities.AccountingEntries;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AccountingEntriesDao {
    public List<AccountingEntries> getAllAccountingEntries()
    {

        Connection con = getConnection();
        List<AccountingEntries> accountingEntries = new ArrayList<AccountingEntries>();
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from AsientosContables";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while(rs.next()){
                    AccountingEntries newAccountingEntries = new AccountingEntries(
                            rs.getInt("IdEmpleado"),
                            rs.getString("Descripcion"),
                            rs.getString("Cuenta"),
                            rs.getString("TipoMovimiento"),
                            rs.getDate("FechaAsiento"),
                            rs.getDouble("MontoAsiento"),
                            rs.getString("Estado")
                    );
                    newAccountingEntries.setId(rs.getInt("id"));
                    accountingEntries.add(newAccountingEntries);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return accountingEntries;
        }
    }

    public boolean createAccountingEntries(AccountingEntries accountingEntries) {
            String query = "INSERT INTO products VALUES (" + accountingEntries.getIdEmpleado() + ",'" +
                    accountingEntries.getDescripcion() + "','" +
                    accountingEntries.getCuenta() + "','" +
                    accountingEntries.getTipoMovimiento() + "'," +
                    accountingEntries.getFechaAsiento() + "," +
                    accountingEntries.getMontoAsiento() + ",'" +
                    accountingEntries.getEstado() + "')";
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

    private AccountingEntries getAccountingEntriesBy_Id(int id){
        String query = "Select * from AsientosContables WHERE id ="+ id;
        return getAccountingEntries(query);
    }

    private AccountingEntries getAccountingEntries(String query){
        try {
            AccountingEntries AccountingEntries = new AccountingEntries();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                AccountingEntries newAccountingEntries = new AccountingEntries(
                        rs.getInt("IdEmpleado"),
                        rs.getString("Descripcion"),
                        rs.getString("Cuenta"),
                        rs.getString("TipoMovimiento"),
                        rs.getDate("getFechaAsiento"),
                        rs.getDouble("SalarioMensual"),
                        rs.getString("IdNomina")
                );
                newAccountingEntries.setId(rs.getInt("id"));
                AccountingEntries = newAccountingEntries;
            }
            return AccountingEntries;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
