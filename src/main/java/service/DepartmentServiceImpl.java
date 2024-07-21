package service;

import entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reponsitory.DepartmentReponsitory;

@Service
@AllArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentReponsitory departmentReponsitory;

    @Override
    public Department create(Department department) {
        return departmentReponsitory.save(department);
    }
}
