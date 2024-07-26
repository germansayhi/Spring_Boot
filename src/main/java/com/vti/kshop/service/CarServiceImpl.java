package com.vti.kshop.service;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import com.vti.kshop.mapper.CarMapper;
import com.vti.kshop.reponsitory.CarReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{
    private CarReponsitory carReponsitory;
    @Override
    public CarDto create(CarCreateForm form) {
        var car = CarMapper.map(form);
        var savedCar= carReponsitory.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carReponsitory.findAll(pageable)
                .map(CarMapper::map);

    }

    @Override
    public CarDto findById(Long id) {
        return carReponsitory.findById(id)
                .map(CarMapper::map)
                .orElse(null);
    }

    @Override
    public CarDto update(Long id, CarUpdateForm form) {
        var optional = carReponsitory.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var car = optional.get();
        CarMapper.map(form,car);
        var saveCar = carReponsitory.save(car);
        return CarMapper.map(saveCar);

    }

    @Override
    public void deleteId(Long id) {
        carReponsitory.deleteById(id);
    }
}
