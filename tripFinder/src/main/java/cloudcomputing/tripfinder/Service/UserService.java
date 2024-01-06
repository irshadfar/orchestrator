package cloudcomputing.tripfinder.Service;

import cloudcomputing.tripfinder.Models.LoginUser;
import cloudcomputing.tripfinder.Models.UserRegistrationData;
import cloudcomputing.tripfinder.Models.LoginResponse;
import cloudcomputing.tripfinder.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse registerData(UserRegistrationData userRegistrationData) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            userRepository.save(userRegistrationData);
            loginResponse.setLogin("User registered successfully");
        } catch (Exception e) {
            loginResponse.setLogin("User could not be registerd");
        }
        return loginResponse;
    }

    public LoginResponse validateUser(LoginUser loginUser) {
        LoginResponse response = new LoginResponse();
        try {
            UserRegistrationData userData = userRepository.findByEmail(loginUser.getEmail());
            if (userData.getPassword().equals(loginUser.getPassword())) {

                response.setLogin("succss");
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
