package com.ereyes.Services;

import com.ereyes.Dao.DeductionTypeDao;
import com.ereyes.Entities.DeductionType;
import com.ereyes.Entities.IncomeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class DeductionTypeService {
    @Autowired
    private DeductionTypeDao deductionTypeDao;

    public List<DeductionType> getAllDeductionTypes(){
        return this.deductionTypeDao.getAllDeductionTypes();
    }

    public boolean createDeductionType(DeductionType deductionType){
        return this.deductionTypeDao.createDeductionType(deductionType);
    }


    public boolean updateDeduction(DeductionType deduction){
        return this.deductionTypeDao.updateDeductionType(deduction);
    }
}
