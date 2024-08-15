package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

}
