package com.vti.kshop.service;

import com.vti.kshop.dto.CarDetailsDto;
import com.vti.kshop.entity.CarDetails;
import com.vti.kshop.form.CarDetailsCreateForm;
import com.vti.kshop.form.CarDetailsUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarDetailsService {
    CarDetails create(Long carId, CarDetailsCreateForm form);

    Page<CarDetailsDto> findAll(Pageable pageable);

    CarDetailsDto findByID(Long id);

    CarDetailsDto update(Long id, CarDetailsUpdateForm form);

    void deleteById(Long id);


}
