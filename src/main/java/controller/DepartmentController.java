package controller;

import entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.DepartmentService;

@RestController
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("/api/v2/departments")
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }
}
