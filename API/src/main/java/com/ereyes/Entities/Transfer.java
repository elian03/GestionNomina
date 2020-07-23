package com.ereyes.Entities;

import com.ereyes.Enum.TransferType;

import java.util.Calendar;
import java.util.Date;

public class Transfer {


    public int Id;
    public int ProductId;
    public Date Date;
    public TransferType TransferType;
    public long Quantity;
    public double UnitCost;

    public Transfer(int productId, Date date, TransferType transferType, long quantity, double unitCost) {
        ProductId = productId;
        Date = date;
        TransferType = transferType;
        Quantity = quantity;
        UnitCost = unitCost;
    }

    public Transfer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public com.ereyes.Enum.TransferType getTransferType() {
        return TransferType;
    }

    public void setTransferType(com.ereyes.Enum.TransferType transferType) {
        TransferType = transferType;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        Quantity = quantity;
    }

    public double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(double unitCost) {
        UnitCost = unitCost;
    }
}