package et.gov.empProfile.service;

import et.gov.empProfile.dto.EmployeeResponse;
import et.gov.empProfile.entity.Employee;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println("========service");
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeResponse> getEmpInfo() {
        return employeeRepository.getJoinInformation();
    }

    @Override
    public Optional<Employee> findById(int id) throws DataNotFoundException{
        Employee emp = employeeRepository.findById(id).orElse(null);
        if (emp ==null){
            throw new DataNotFoundException("there is no data with id----"+id);
        }
            return Optional.of(emp);

    }



    @Override
    public Employee updateEmployee(int id,Employee employee) {
        //Sadik


       Employee existingEmp = employeeRepository.findById(id).orElse(null);
        System.out.println("=====addess list======="+existingEmp.getAddressList());
            existingEmp.setEmp_Id(employee.getEmp_Id());
            existingEmp.setFirst_Name(employee.getFirst_Name());
            existingEmp.setMiddle_Name(employee.getMiddle_Name());
            existingEmp.setLast_Name(employee.getLast_Name());
            existingEmp.setSalary(employee.getSalary());
            existingEmp.setDate_Of_Birth(employee.getDate_Of_Birth());
            return employeeRepository.save(existingEmp);
    }

    @Override
    public void deleteUser(int id) {
        employeeRepository.deleteById(id);
    }
}
