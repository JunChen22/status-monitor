package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.OverallUptime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverallUpTimeRepository extends JpaRepository<OverallUptime, Long> {

        OverallUptime findById(long id);

}
