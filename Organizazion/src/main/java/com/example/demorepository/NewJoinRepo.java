package com.example.demorepository;

import com.example.demoentity.NewJoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewJoinRepo extends JpaRepository<NewJoin,Long> {

}
