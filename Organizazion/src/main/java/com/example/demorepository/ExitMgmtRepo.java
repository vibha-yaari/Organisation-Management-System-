package com.example.demorepository;

import com.example.demoentity.ExitMgmt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExitMgmtRepo extends JpaRepository<ExitMgmt, Long> {
}
