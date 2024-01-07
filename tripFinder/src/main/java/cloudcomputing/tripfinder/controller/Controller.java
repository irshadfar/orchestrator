package cloudcomputing.tripfinder.controller;


import cloudcomputing.tripfinder.Models.*;
import cloudcomputing.tripfinder.Service.RandomNumberWeatherService;
import cloudcomputing.tripfinder.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

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
     * end point to register users
     */
    @GetMapping("/trip-id")
    @CrossOrigin
    public ResponseEntity<TripIdResponse> registerUsers() {

        return new ResponseEntity<TripIdResponse>(randomNumberWeatherService.generateTripAndUserID(), HttpStatus.OK);
    }
    /**
     * end point to get trip data
     */
    @PostMapping("/trip-data")
    @CrossOrigin
    public ResponseEntity<ResponseObject> getWeather(
            @RequestBody RequestTripObject requestTripObject
    ) {
        return new ResponseEntity<ResponseObject>(randomNumberWeatherService.getTripData(requestTripObject), HttpStatus.OK);
    }

    /**
     * end point to register users
     */
    @PostMapping("/user-registration")
    @CrossOrigin
    public ResponseEntity<LoginResponse> registerUser(
            @RequestBody @Valid UserRegistrationData userRegistrationData) {

        return new ResponseEntity<LoginResponse>(userService.registerData(userRegistrationData), HttpStatus.OK);
    }
    /**
     * end point to log-in users
     */
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<LoginResponse> login (
            @RequestBody @Valid LoginUser loginUser) {

        return new ResponseEntity<LoginResponse>(userService.validateUser(loginUser), HttpStatus.OK);
    }

    /**
     * exception handling to validate request objects for registering and logging users
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException exception) {

        ExceptionResponse wrapper = new ExceptionResponse();
        wrapper.setError(exception.getBindingResult().getFieldError().getDefaultMessage());
        wrapper.setTimeStamp(String.valueOf(new Timestamp(System.currentTimeMillis())));
        wrapper.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(wrapper, HttpStatus.BAD_REQUEST);
    }

}
