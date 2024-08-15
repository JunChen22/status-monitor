package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
        Applications  findByApplicationName(String name);
}
