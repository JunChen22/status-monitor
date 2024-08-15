package com.junchen.statusmonitor.repository;

import com.junchen.statusmonitor.entity.UpdateEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateEventRepository extends JpaRepository<UpdateEvent, Long> {

}
