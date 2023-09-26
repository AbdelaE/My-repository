package et.gov.empProfile.controller;

import et.gov.empProfile.dto.EmployeeDto;
import et.gov.empProfile.dto.EmployeeResponse;
import et.gov.empProfile.entity.Employee;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.repository.EmployeeRepository;
import et.gov.empProfile.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employeeProfile")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        System.out.println("=================insiide");
        Employee savedEmp = employeeService.saveEmployee(employeeDto.getEmployee());
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("allEmployee")
    public ResponseEntity<List<Employee>> findAllEmploye() {
        List<Employee> empList = employeeService.findAllEmp();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("getJoinInfo")
    public ResponseEntity<List<EmployeeResponse>> getInfo() {
        List<EmployeeResponse> joindInfo = employeeService.getEmpInfo();
        return new ResponseEntity<>(joindInfo, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id")  int id)throws DataNotFoundException {
        Optional<Employee> empById = employeeService.findById(id);
        return new ResponseEntity<>(empById, HttpStatus.OK);
    }

    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeRequest) {
        Employee updateEmployee = employeeService.updateEmployee(id,employeeRequest.getEmployee());
        return new ResponseEntity<Employee>(updateEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}