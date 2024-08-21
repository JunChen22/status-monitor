package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {

        Applications findById(long id);

}
