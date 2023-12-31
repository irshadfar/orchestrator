package cloudcomputing.tripfinder.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserRegistrationData {

    @Id
    @GeneratedValue
    private Long Id;
    @NotEmpty(message = "name can not be empty")
    private String name;
    @Email(message = "must be a valid email")
    private String email;
    @NotEmpty(message = "password cannot be empty")
    private String password;
}
