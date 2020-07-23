package com.ereyes.Dao;

import com.ereyes.Entities.Product;
import com.ereyes.Entities.Transfer;
import com.ereyes.Enum.TransferType;
import com.ereyes.Models.TransferResponse;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.Date;

@Repository
public class ProductDao {

    public List<Product> getAllProducts(){
        Connection con = getConnection();
        List<Product> products = new ArrayList<Product>() {
        };
        if(con == null){
            return null;
        }else {
            Statement state;
            String query = "Select * from Products";
            try{
                state = con.createStatement();
                ResultSet rs = state.executeQuery(query);

                while(rs.next()){
                    Product newProduct = new Product(
                            rs.getString("product_name"),
                            rs.getString("product_description"),
                            rs.getLong("quantity_storaged"),
                            rs.getDouble("purchase_price"),
                            rs.getDouble("sale_price")
                    );
                    newProduct.setId(rs.getInt("id"));
                    products.add(newProduct);
                }
            }catch (SQLException ex){
                return null;
            } catch (Exception e){
                return null;
            }
            return products;
        }
    }

    public Product getProductById(int id) {
        Connection con = getConnection();
        if (con == null) {
            return null;
        } else {
             return getProductBy_Id(id);
        }
    }

    public boolean createProduct(Product product) {
        Product productToCheck;
        productToCheck = getProductByName(product.getProductName());
        if(productToCheck != null){
            return false;
        }else{
            String query = "INSERT INTO products VALUES ('"+product.getProductName()+"','"+
                    product.getDescription()+"',"+
                    product.getQuantityStoraged()+","+
                    product.getPurchasePrice()+","+
                    product.getSalePrice()+")";
            return executeUpdate(query);

        }

    }

    public boolean updateProduct(Product product){
        Product productToCheck;
        productToCheck = getProductById(product.getId());
        if(product != productToCheck){
            String query = "UPDATE products SET product_name = '"+product.getProductName()+
                    "', product_description = '"+ product.getDescription()+
                    "', quantity_storaged ="+ product.getQuantityStoraged()+
                    ", purchase_price= "+ product.getPurchasePrice()+
                    ", sale_price="+product.getSalePrice()+" WHERE id ="+ product.getId();
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

    public TransferResponse entryProducts(int id, long entry){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        int year = Calendar.YEAR;
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1); // <-- months start
        cal.set(Calendar.DAY_OF_MONTH, day);
        java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());

        Connection con = getConnection();
        Product product = getProductById(id);
        product.setQuantityStoraged(product.getQuantityStoraged() + entry);
        int resultUpdate, resultTransfer;
        Statement state;
        String query = "UPDATE products SET quantity_storaged = "+ product.getQuantityStoraged() + " WHERE id ="+ id;
        try {
            state = con.createStatement();
            resultUpdate = state.executeUpdate(query);
        }catch (SQLException e){
            return null;
        }
        if(resultUpdate == 1) {
            Transfer transfer = new Transfer(product.getId(), Date.from(Instant.now()), TransferType.EntryTransfer,
                    entry, product.getPurchasePrice());
            String queryTransfer= "INSERT INTO TRANSFERS ([product_id]" +
                    "           ,[transfer_type]" +
                    "           ,[quantity]" +
                    "           ,[unit_cost]) VALUES("+ transfer.ProductId+
            ","+ transfer.TransferType.ordinal()+","+
                    transfer.Quantity+"," +  transfer.UnitCost+")";
            try{
                resultTransfer = state.executeUpdate(queryTransfer);
            }catch (SQLException e){
                return null;
            }
            if (resultTransfer == 1) {
                return new TransferResponse(transfer);
            }
            else{
                return null;
            }
        }else{
            return null;
        }
    }

    public TransferResponse outProducts(int id, long out){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        int year = Calendar.YEAR;
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1); // <-- months start
        cal.set(Calendar.DAY_OF_MONTH, day);
        java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());

        Connection con = getConnection();
        Product product = getProductById(id);
        product.setQuantityStoraged(product.getQuantityStoraged() - out);
        long quantity = product.getQuantityStoraged();
        if(quantity - out <=0){
            return new TransferResponse("QuantitySoldOut");
        }
        int resultUpdate, resultTransfer;
        Statement state;
        String query = "UPDATE products SET quantity_storaged = "+ product.getQuantityStoraged() + " WHERE id ="+ id;
        try {
            state = con.createStatement();
            resultUpdate = state.executeUpdate(query);
        }catch (SQLException e){
            return null;
        }
        if(resultUpdate == 1) {
            Transfer transfer = new Transfer(product.getId(), Date.from(Instant.now()), TransferType.OutTransfer,
                    out, product.getSalePrice());
            String queryTransfer= "INSERT INTO TRANSFERS ([product_id]" +
                    "           ,[transfer_type]" +
                    "           ,[quantity]" +
                    "           ,[unit_cost]) VALUES("+ transfer.ProductId+
                    ","+ transfer.TransferType.ordinal() +","+
                    transfer.Quantity+"," +  transfer.UnitCost+")";
            try{
                resultTransfer = state.executeUpdate(queryTransfer);
            }catch (SQLException e){
                return null;
            }
            if (resultTransfer == 1) {
                return new TransferResponse(transfer);
            }
            else{
                return null;
            }
        }else{
            return null;
        }
    }

    public String writeReport() {
        String ruta = "reporte.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
            bw.close();
            return "La accion fue un exito";
        }catch (Exception ex){
            return "Hubo un problema al ejecutar la accion" + ex.getMessage();
        }
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

    private Product getProductBy_Id(int id){
        String query = "Select * from products WHERE id ="+ id;
        return getProduct(query);
    }

    private Product getProductByName(String name){
        String query = "Select * from products WHERE product_name ="+ name;
        return getProduct(query);
    }

    private Product getProduct(String query){
        try {
            Product product = new Product();
            Connection con = getConnection();
            Statement state;
            state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {
                Product newProduct = new Product(
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getLong("quantity_storaged"),
                        rs.getDouble("purchase_price"),
                        rs.getDouble("sale_price")
                );
                newProduct.setId(rs.getInt("id"));
                product = newProduct;
            }
            return product;
        } catch (SQLException ex) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }



}
