package com.vti.kshop.service;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.form.AccessoryCreateForm;
import com.vti.kshop.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    AccessoryDto create( AccessoryCreateForm form);

    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto findByID(Long id);

    AccessoryDto update(Long id, AccessoryUpdateForm form);

    void deleteById(Long id);


}
