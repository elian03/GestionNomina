package com.ereyes.Services;

import com.ereyes.Dao.IncomeTypeDao;

import com.ereyes.Entities.Employee;
import com.ereyes.Entities.IncomeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class IncomeTypeService {
    @Autowired
    private IncomeTypeDao incomeTypeDao;

    public List<IncomeType> getAllIncomeTypes(){
        return this.incomeTypeDao.getAllIncomeTypes();
    }

    public boolean createIncomeTypes(IncomeType IncomeType){
        return this.incomeTypeDao.createIncomeType(IncomeType);
    }

    public boolean updateIncome(IncomeType income){
        return this.incomeTypeDao.updateIncomeTypes(income);
    }


}
