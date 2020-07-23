package com.ereyes.Services;

import com.ereyes.Dao.TransferDao;
import com.ereyes.Entities.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferDao transferDao;

    public Transfer getTransferById(int id){
        return transferDao.getTransferById(id);
    }


    public List<Transfer> getAllTransfers(){
        return transferDao.getAllTransfers();
    }

}
