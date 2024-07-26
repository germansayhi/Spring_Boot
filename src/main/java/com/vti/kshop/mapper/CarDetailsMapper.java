package com.vti.kshop.mapper;

import com.vti.kshop.dto.CarDetailsDto;
import com.vti.kshop.entity.CarDetails;
import com.vti.kshop.form.CarDetailsCreateForm;
import com.vti.kshop.form.CarDetailsUpdateForm;

public class CarDetailsMapper {
    public static CarDetails map(CarDetailsCreateForm form){
        var carDetails = new CarDetails();
        carDetails.setLicensePlate(form.getLicensePlate());
        carDetails.setRepairDate(form.getRepairDate());
        carDetails.setStatusDamaged(form.getStatusDamaged());
        carDetails.setName(form.getName());
        carDetails.setPrice(form.getPrice());
        carDetails.setRepiarStatus(form.getRepiarStatus());
        return carDetails;
    }
    public static CarDetailsDto map(CarDetails carDetails){
        var dto = new CarDetailsDto();
        dto.setId(carDetails.getId());
        dto.setLicensePlate(carDetails.getLicensePlate());
        dto.setRepairDate(carDetails.getRepairDate());
        dto.setName(carDetails.getName());
        dto.setPrice(carDetails.getPrice());
        dto.setStatusDamaged(carDetails.getStatusDamaged());
        dto.setRepiarStatus(carDetails.getRepiarStatus());
        return dto;
    }
    public static void map(CarDetailsUpdateForm form, CarDetails carDetails){
        carDetails.setLicensePlate(form.getLicensePlate());
        carDetails.setRepairDate(form.getRepairDate());
        carDetails.setStatusDamaged(form.getStatusDamaged());
        carDetails.setName(form.getName());
        carDetails.setPrice(form.getPrice());
        carDetails.setRepiarStatus(form.getRepiarStatus());
    }
}
