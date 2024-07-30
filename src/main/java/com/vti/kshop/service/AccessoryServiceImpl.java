package com.vti.kshop.service;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.form.AccessoryCreateForm;
import com.vti.kshop.form.AccessoryUpdateForm;
import com.vti.kshop.mapper.AccessoryMapper;
import com.vti.kshop.reponsitory.AccessoryRepository;
import com.vti.kshop.reponsitory.CarReponsitory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements  AccessoryService{
    private AccessoryRepository accessoryRepository;
    private CarReponsitory carReponsitory;

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var car = carReponsitory.findByLicensePlateAndRepairDate(
                form.getLicensePlate(),
                form.getRepairDate()
        );
        if(car == null) return null;
        var accessory = AccessoryMapper.map(form);
        accessory.setCar(car);
        var saveAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(saveAccessory);
    }

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto findByID(Long id) {
        return accessoryRepository.findById(id)
                .map(AccessoryMapper::map)
                .orElse(null);
    }

    @Override
    public AccessoryDto update(Long id, AccessoryUpdateForm form) {
        var optional = accessoryRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var accessory = optional.get();
        AccessoryMapper.map(form,accessory);
        var saveCar = accessoryRepository.save(accessory);
        return AccessoryMapper.map(saveCar);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
