package et.gov.empProfile.repository;

import et.gov.empProfile.dto.EmployeeResponse;
import et.gov.empProfile.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT new et.gov.empProfile.dto.EmployeeResponse (e.First_Name,a.email) FROM Employee e JOIN e.addressList a")
    List<EmployeeResponse> getJoinInformation();
}
