package et.gov.empProfile.controller;

import et.gov.empProfile.entity.Department;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDep")
    public ResponseEntity<Department> saveDep(@RequestBody @Valid Department department) {
        Department saveDep = departmentService.saveDepartment(department);
        return new ResponseEntity<>(saveDep, HttpStatus.CREATED);

    }
    @GetMapping("/allDepartment")
    public ResponseEntity<List<Department>> findAllDep(){
          List<Department> departments = departmentService.finAllDEp();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }
    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  int id) throws DataNotFoundException {
        Optional<Optional<Department>> depByid = departmentService.findById(id);
        return new ResponseEntity<>(depByid, HttpStatus.OK);
    }
    @PutMapping("/updateDepartmentById/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody @Valid Department department) {
        department.setId(id);
        Department updateDep = departmentService.updateDepartment(department);
        return new ResponseEntity<Department>(updateDep, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteDepartmentById/{id}")
    public ResponseEntity<Void> deleteDepartmentByI(@PathVariable int id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
