package cloudcomputing.tripfinder.Service;

import cloudcomputing.tripfinder.Models.LoginUser;
import cloudcomputing.tripfinder.Models.UserRegistrationData;
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

    public ResponseEntity<String> registerData(UserRegistrationData userRegistrationData) {
        userRepository.save(userRegistrationData);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> validateUser(LoginUser loginUser) {
        try {
            UserRegistrationData userData = userRepository.findByEmail(loginUser.getEmail());
            if (userData.getPassword().equals(loginUser.getPassword())) {
                return new ResponseEntity<>("Login successful", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password is incorrect", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("User is not registered", HttpStatus.NOT_FOUND);
        }
    }
}
