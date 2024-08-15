package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.EndpointDailyUptime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointDailyUptimeRepository extends JpaRepository<EndpointDailyUptime, Long> {

}
