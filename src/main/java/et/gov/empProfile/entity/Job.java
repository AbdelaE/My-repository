package et.gov.empProfile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Job")
public class Job {
    @Id
    @GeneratedValue()
    private int id;
    @NotBlank(message = "job title can not be null")
    private String Job_Title;
    @NotBlank(message = "Description can not be null")
    private String Description;

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Job_Id", referencedColumnName = "id")
    private List<Employee> employeeList;
}
