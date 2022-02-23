package com.example.demoservice;


import com.example.demoentity.ExitMgmt;
import com.example.demorepository.ExitMgmtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExitMgmtService {

@Autowired
private  ExitMgmtRepo exitMgmtRepo;
    public List<ExitMgmt> listAll() {
        return exitMgmtRepo.findAll();
    }

    public void save(ExitMgmt exitMgmt) {
        exitMgmtRepo.save(exitMgmt);
    }


    public ExitMgmt get(long id) {
        return exitMgmtRepo.findById(id).get() ;
    }

    public void delete(long id) {
        exitMgmtRepo.deleteById(id);
    }
}
