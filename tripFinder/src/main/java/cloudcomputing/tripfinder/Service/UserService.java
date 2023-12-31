package cloudcomputing.tripfinder.Service;

import cloudcomputing.tripfinder.Models.UserRegistrationData;
import cloudcomputing.tripfinder.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerData(UserRegistrationData userRegistrationData) {
//        try {
            userRepository.save(userRegistrationData);
            return "User registered";
//        } catch (Exception e) {
//            throw e;
//        }
    }

}
