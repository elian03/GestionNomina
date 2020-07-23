package com.ereyes.Services;

import com.ereyes.Dao.EmployeeDao;
import com.ereyes.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployee(){
        return this.employeeDao.getAllEmployees();
    }

    public boolean createEmploee(Employee employee){
        return this.employeeDao.createEmployee(employee);
    }

    public Employee getEmployeeById(int id){
        return this.employeeDao.getEmployeeById(id);
    }

    public boolean updateEmployee(Employee employee){
        return this.employeeDao.updateEmployee(employee);
    }

}
