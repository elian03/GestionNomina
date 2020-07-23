package com.ereyes.Entities;

public class Product {

    private int Id;
    private String ProductName;
    private String Description;
    private long QuantityStoraged;
    private double PurchasePrice;
    private double SalePrice;

    public Product(String productName, String description, long quantityStoraged, double purchasePrice, double salePrice) {
        ProductName = productName;
        Description = description;
        QuantityStoraged = quantityStoraged;
        PurchasePrice = purchasePrice;
        SalePrice = salePrice;
    }

    public Product() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getQuantityStoraged() {
        return QuantityStoraged;
    }

    public void setQuantityStoraged(long quantityStoraged) {
        QuantityStoraged = quantityStoraged;
    }

    public double getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }
}
