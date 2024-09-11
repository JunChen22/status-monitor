package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.EndpointStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointStatusRepository extends JpaRepository<EndpointStatus, Long> {

        EndpointStatus findById(long id);

}
