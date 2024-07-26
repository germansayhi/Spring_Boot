package com.vti.kshop.reponsitory;

import com.vti.kshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReponsitory extends JpaRepository<Car, Long> {

}
