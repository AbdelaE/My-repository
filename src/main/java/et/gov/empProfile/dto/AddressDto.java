package et.gov.empProfile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    @NotBlank(message = "city should not be null")
    private String City;
    @NotBlank(message = "sub city should not be null")
    private String Sub_City;
    @Email(message = "invalid email address")
    private String Email;
}
