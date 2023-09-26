package et.gov.empProfile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue()

    private int id;
    @NotBlank(message = "department should not be null")
    private String Dep_Name;
    @NotBlank(message = "description should not be null")
    private String Description;

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Dep_Id", referencedColumnName = "id")
    private List<Employee> employeeList;

}
