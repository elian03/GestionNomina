package com.ereyes.Services;

import com.ereyes.Dao.ProductDao;
import com.ereyes.Entities.Product;
import com.ereyes.Models.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts(){
        return this.productDao.getAllProducts();
    }

    public boolean createProduct(Product product){
        return this.productDao.createProduct(product);
    }

    public Product getProductById(int id){
        return this.productDao.getProductById(id);
    }

    public boolean updateProduct(Product product){
        return this.productDao.updateProduct(product);
    }

    public TransferResponse entryProducts(int id, long entry){
        return this.productDao.entryProducts(id,entry);
    }

    public TransferResponse outProducts(int id, long out){
        return this.productDao.outProducts(id,out);
    }

    public String writeReport(){
        return this.productDao.writeReport();
    }
}
