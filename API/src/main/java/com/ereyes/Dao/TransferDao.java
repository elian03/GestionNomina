package com.ereyes.Dao;

import com.ereyes.Entities.Transfer;
import com.ereyes.Enum.TransferType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferDao {

    public Transfer getTransferById(int id){
        Connection con = getConnection();
        if (con == null) {
            return null;
        } else {
            return getTransferBy_Id(id);
        }
    }

    private Transfer getTransferBy_Id(int id){
        String query = "Select * from transfers WHERE id ="+ id;
        return getTransfer(query);
    }

    private Connection getConnection() {
        try{
            String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress;database=ProductManager;";
            Connection cnn = DriverManager.getConnection(connectionUrl,
                    "sa","ProdoctivityNovosit");
            return cnn;
        }catch (SQLException ex){
            return null;
        }

    }

    private Transfer getTransfer(String query){
        try {
            Transfer transfer = new Transfer();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                String type;
                if(rs.getInt("transfer_type") == 1){
                    type = "EntryTransfer";
                }else{
                    type ="OutTransfer";
                }
                Transfer newTransfer = new Transfer(
                        rs.getInt("product_id"),
                        rs.getDate("date_created"),
                        TransferType.valueOf(type),
                        rs.getLong("quantity"),
                        rs.getDouble("unit_cost")
                );
                newTransfer.setId(rs.getInt("id"));
                transfer = newTransfer;
            }
            return transfer;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Transfer> getAllTransfers() {
        Connection con = getConnection();
        List<Transfer> transfers = new ArrayList<Transfer>() {
        };
        if (con == null) {
            return null;
        } else {
            Statement state;
            String query = "Select * from transfers";
            try {
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while (rs.next()) {
                    String type;
                    if (rs.getInt("transfer_type") == 1) {
                        type = "EntryTransfer";
                    } else {
                        type = "OutTransfer";
                    }
                    Transfer newTransfer = new Transfer(
                            rs.getInt("product_id"),
                            rs.getDate("date_created"),
                            TransferType.valueOf(type),
                            rs.getLong("quantity"),
                            rs.getDouble("unit_cost")
                    );
                    newTransfer.setId(rs.getInt("id"));
                    transfers.add(newTransfer);
                }
            } catch (SQLException ex) {
                return null;
            } catch (Exception e) {
                return null;
            }
            return transfers;
        }
    }
}
