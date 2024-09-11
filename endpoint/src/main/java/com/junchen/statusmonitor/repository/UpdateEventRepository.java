package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.UpdateEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateEventRepository extends JpaRepository<UpdateEvent, Long> {

        UpdateEvent findById(long id);
        List<UpdateEvent> findAllByApplicationId(long applicationId);

}
