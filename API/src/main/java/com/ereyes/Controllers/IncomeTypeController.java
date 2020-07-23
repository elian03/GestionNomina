package com.ereyes.Controllers;

import com.ereyes.Entities.IncomeType;
import com.ereyes.Services.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"*"}, allowedHeaders = "true")

@RestController
@RequestMapping("api/IncomeType")
public class IncomeTypeController {
    @Autowired
    private IncomeTypeService incomeTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<IncomeType> getAllIncomeTypes(){
        return incomeTypeService.getAllIncomeTypes();
    }
    @CrossOrigin()
    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void CreateIncome(@RequestBody IncomeType incomeType){
        incomeTypeService.createIncomeTypes(incomeType);
    }
}
