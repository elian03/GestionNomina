package com.ereyes.Controllers;
import com.ereyes.Entities.Employee;
import com.ereyes.Entities.Product;
import com.ereyes.Services.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = {"*"}, allowedHeaders = "true")

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
@CrossOrigin()
    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void CreateEmployee(@RequestBody Employee employee){
        employeeService.createEmploee(employee);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean UpdateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }
}
