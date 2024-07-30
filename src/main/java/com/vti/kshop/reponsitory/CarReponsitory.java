package com.vti.kshop.reponsitory;

import com.vti.kshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CarReponsitory extends JpaRepository<Car, Long> {
    Car findByLicensePlateAndRepairDate(String licensePlate, LocalDate repairDate);
}
