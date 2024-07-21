package reponsitory;

import entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentReponsitory extends JpaRepository<Department, Integer> {
}
