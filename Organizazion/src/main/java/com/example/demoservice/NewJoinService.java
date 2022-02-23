package com.example.demoservice;

import com.example.demoentity.NewJoin;
import com.example.demorepository.NewJoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewJoinService {
@Autowired
private NewJoinRepo newJoinRepo;
    public List<NewJoin> listAll() {
        return newJoinRepo.findAll();
    }
    public void save(NewJoin newJoin) {
        newJoinRepo.save(newJoin);
    }

    public NewJoin get(long id) {
        return newJoinRepo.findById(id).get();
    }

    public void delete(long id) {
        newJoinRepo.deleteById(id);
    }


}
