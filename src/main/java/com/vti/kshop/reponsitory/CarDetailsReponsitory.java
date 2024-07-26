package com.vti.kshop.reponsitory;

import com.vti.kshop.entity.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailsReponsitory extends JpaRepository<CarDetails, Long> {
}
