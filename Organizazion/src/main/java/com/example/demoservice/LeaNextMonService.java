package com.example.demoservice;

import com.example.demoentity.LeaNextMon;
import com.example.demorepository.LeaNextMonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaNextMonService {
    @Autowired
    private LeaNextMonRepo leaNextMonRepo;
    public List<LeaNextMon> listAll() {
        return leaNextMonRepo.findAll();
    }

    public void save(LeaNextMon leaNextMon) {
        leaNextMonRepo.save(leaNextMon);
    }

    public LeaNextMon get(long id) {
        return leaNextMonRepo.findById(id).get();
    }

    public void delete(long id) {
        leaNextMonRepo.deleteById(id);
    }
}
