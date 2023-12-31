package cloudcomputing.tripfinder.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {

    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "password must not be empty")
    private String password;
}
