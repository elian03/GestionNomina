package com.ereyes.Controllers;

import com.ereyes.Entities.Product;
import com.ereyes.Entities.Transfer;
import com.ereyes.Models.TransferResponse;
import com.ereyes.Services.ProductService;
import com.ereyes.Services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"}, allowedHeaders = "true")
@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private TransferService transferService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/transfers", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers(){
        return transferService.getAllTransfers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "transfer/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable("id") int id){
        return transferService.getTransferById(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean UpdateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void CreateProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @RequestMapping(value = "/entry/{id}/{entry}",method = RequestMethod.PUT)
    public TransferResponse entryProduct(@PathVariable("id") int id, @PathVariable("entry") long entry){
        return this.productService.entryProducts(id,entry);
    }

    @RequestMapping(value = "/out/{id}/{entry}",method = RequestMethod.PUT)
    public TransferResponse outProduct(@PathVariable("id") int id, @PathVariable("entry") long out){
        return this.productService.outProducts(id,out);
    }

    @RequestMapping(value = "/report",method = RequestMethod.GET)
    public String writeReport(){
        return productService.writeReport();
    }
}
