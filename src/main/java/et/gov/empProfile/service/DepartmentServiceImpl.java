package et.gov.empProfile.service;

import et.gov.empProfile.entity.Department;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Optional<Department>> findById(int id) throws DataNotFoundException {
        Department dep = departmentRepository.findById(id).orElse(null);
        if (dep ==null){
            throw new DataNotFoundException("there is no data with id---"+id);
        }
        return Optional.of(Optional.ofNullable(dep));

    }

    @Override
    public Department updateDepartment(Department department) {
        Department savedDep = departmentRepository.findById(department.getId()).orElse(null);
        savedDep.setDep_Name(department.getDep_Name());
        savedDep.setDescription(department.getDescription());
        return departmentRepository.save(savedDep);
    }

    @Override
    public List<Department> finAllDEp() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }
}
