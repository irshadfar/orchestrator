package cloudcomputing.tripfinder.controller;


import cloudcomputing.tripfinder.Models.*;
import cloudcomputing.tripfinder.Service.RandomNumberWeatherService;
import cloudcomputing.tripfinder.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tripAdvisor")
public class Controller {

    private final RandomNumberWeatherService randomNumberWeatherService;
    private final UserService userService;

    public Controller(RandomNumberWeatherService randomNumberWeatherService, UserService userService) {
        this.randomNumberWeatherService = randomNumberWeatherService;
        this.userService = userService;
    }

    /**
     * end point to register users*/
    @GetMapping("/trip-id")
    public ResponseEntity<TripIdResponse> registerUsers() {

        return new ResponseEntity<TripIdResponse>(randomNumberWeatherService.generateTripAndUserID(), HttpStatus.OK);
    }

    @PostMapping("/trip-data")
    public ResponseEntity<ResponseObject> getWeather(
            @RequestBody RequestTripObject requestTripObject
            ){
        return new ResponseEntity<ResponseObject>(randomNumberWeatherService.getTripData(requestTripObject), HttpStatus.OK);
    }


    @PostMapping("/user-registration")
    public ResponseEntity<String> registerUser(
            @RequestBody @Valid UserRegistrationData userRegistrationData){

        return new ResponseEntity<>(userService.registerData(userRegistrationData), HttpStatus.CREATED);
    }



}
