package et.gov.empProfile.dto;

import et.gov.empProfile.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import java.sql.Blob;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Employee employee;

    //Fields for employee
    //@NotBlank(message = "employee id should not be null")
    private String Emp_Id;
    //@NotBlank(message = "first name id should not be null")
    private String First_Name;
   // @NotBlank(message = "middle name id should not be null")
    private String Middle_Name;
    //@NotBlank(message = "last name id should not be null")
    private String Last_Name;
   // @NotBlank(message = "birth date id should not be null")
    private String Date_Of_Birth;
   // @Min(value = 1000, message = "salary should not be less than 1000")
   // @Max(value = 80000, message = "salary should not be greater than 80000")
    private Double Salary;
    private Blob Image;
}
