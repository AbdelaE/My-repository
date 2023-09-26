package et.gov.empProfile.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Blob;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_Table")
public class Employee {

    @Id
    @GeneratedValue()
    private int id;

    private String Emp_Id;
    private String First_Name;
    private String Middle_Name;
    private String Last_Name;
    private String Date_Of_Birth;
    private Double Salary;
    private Blob Image;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Emp_ID", referencedColumnName = "id")
    private List<Address> addressList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department depId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Job jobId;
}
