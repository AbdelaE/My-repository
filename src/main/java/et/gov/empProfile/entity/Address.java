package et.gov.empProfile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue()
    private int id;

    @Column(name = "City")
    @NotBlank(message = "city should not be null")
    private String city;
    @Column(name = "Sub_City")
    @NotBlank(message = "city should not be null")
    private String subCity;

    @Column(name = "Phone_No")
    @Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
    private String phoneNo;
    @Column(name = "Email")
    @Email(message = "invalid email address")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee empId;


}
