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
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
}
