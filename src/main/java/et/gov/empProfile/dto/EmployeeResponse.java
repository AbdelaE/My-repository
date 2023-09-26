package et.gov.empProfile.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmployeeResponse {

    private String First_Name;
    private String Email;
    private Double Salary;

    public EmployeeResponse(String first_Name, String email) {
        First_Name = first_Name;
        Email = email;
    }

}
