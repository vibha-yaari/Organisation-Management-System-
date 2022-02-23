package com.example.demorepository;

import com.example.demoentity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository <Leaves,Long>{
}
