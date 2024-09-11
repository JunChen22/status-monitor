package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.EndpointDailyUptime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointDailyUptimeRepository extends JpaRepository<EndpointDailyUptime, Long> {

        EndpointDailyUptime findById(long id);

}
