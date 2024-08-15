package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.EndpointStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointStatusRepository extends JpaRepository<EndpointStatus, Long> {

}
