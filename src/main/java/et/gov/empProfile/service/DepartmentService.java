package et.gov.empProfile.service;

import et.gov.empProfile.entity.Department;
import et.gov.empProfile.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Optional<Optional<Department>> findById(int id) throws DataNotFoundException;

    Department updateDepartment(Department department);

    List<Department> finAllDEp();

    void deleteDepartmentById(int id);
}
