package com.vti.kshop.service;

import com.vti.kshop.dto.CarDetailsDto;
import com.vti.kshop.entity.CarDetails;
import com.vti.kshop.form.CarDetailsCreateForm;
import com.vti.kshop.form.CarDetailsUpdateForm;
import com.vti.kshop.mapper.CarDetailsMapper;
import com.vti.kshop.reponsitory.CarDetailsReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarDetailsServiceImlp implements  CarDetailsService{
    private CarDetailsReponsitory carDetailsReponsitory;
    @Override
    public CarDetails create(Long carId, CarDetailsCreateForm form) {
        var optional = carDetailsReponsitory.findById(carId);
        if (optional.isEmpty()) {
            return null;
        }
//        var car = optional.get();
//        var carDetails = CarDetailsMapper.map(form);
//        carDetails.setCar(car);
//        var saveCarDetails = carDetailsReponsitory.save(carDetails);
//        return CarDetailsMapper.map(saveCarDetails);
//    }
    @Override
    public Page<CarDetailsDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CarDetailsDto findByID(Long id) {
        return null;
    }

    @Override
    public CarDetailsDto update(Long id, CarDetailsUpdateForm form) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
         carDetailsReponsitory.deleteById(id);
    }
}
