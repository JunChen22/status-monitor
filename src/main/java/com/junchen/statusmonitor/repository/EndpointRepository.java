package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

        Endpoint findById(long id);

}
