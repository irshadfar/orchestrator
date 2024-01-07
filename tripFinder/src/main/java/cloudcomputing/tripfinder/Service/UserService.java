package cloudcomputing.tripfinder.Service;

import cloudcomputing.tripfinder.Models.LoginUser;
import cloudcomputing.tripfinder.Models.UserRegistrationData;
import cloudcomputing.tripfinder.Models.LoginResponse;
import cloudcomputing.tripfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * registerData - used to register users
     * on success registers users
     * on failure it shows error
     * */
    public LoginResponse registerData(UserRegistrationData userRegistrationData) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            //save user entered data into the database
            userRepository.save(userRegistrationData);

            loginResponse.setLogin("User registered successfully");
        } catch (Exception e) {
            loginResponse.setLogin("User could not be registerd");
        }
        return loginResponse;
    }

    /**
     * validateUser - validate wether the user already exists or not
     * on succes it allows user to login
     * on fail it shows error
     * */
    public LoginResponse validateUser(LoginUser loginUser) {
        LoginResponse response = new LoginResponse();
        try {
            UserRegistrationData userData = userRepository.findByEmail(loginUser.getEmail());
            if (userData.getPassword().equals(loginUser.getPassword())) {

                response.setLogin("success");
            } else {
                response.setLogin("Password is incorrect");
            }
        } catch (Exception e) {
            response.setLogin("User is not registered");
            return response;
        }
        return response;
    }
}
