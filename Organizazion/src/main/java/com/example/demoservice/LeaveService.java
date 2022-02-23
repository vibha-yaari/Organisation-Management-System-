package com.example.demoservice;

import com.example.demoentity.Leaves;
import com.example.demorepository.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveService {

    @Autowired
    private LeaveRepo lvRepo;
    public List<Leaves> listAll() {
        return lvRepo.findAll();
    }

    public void save(Leaves leave) {
        lvRepo.save(leave);
    }

    public Leaves get(long id) {
        return lvRepo.findById(id).get();
    }

    public void delete(long id) {
        lvRepo.deleteById(id);
    }
}
