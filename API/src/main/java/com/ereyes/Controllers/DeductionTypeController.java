package com.ereyes.Controllers;

import com.ereyes.Entities.DeductionType;
import com.ereyes.Services.DeductionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"*"}, allowedHeaders = "true")
@RestController
@RequestMapping("api/DeductionType")
public class DeductionTypeController {

    @Autowired
    private DeductionTypeService deductionTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DeductionType> getAllDeductions(){
        return deductionTypeService.getAllDeductionTypes();
    }
    @CrossOrigin()
    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void CreateDeduction(@RequestBody DeductionType deductionType){
        deductionTypeService.createDeductionType(deductionType);
    }

}
