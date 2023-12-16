package cloudcomputing.tripfinder.Controller;


import cloudcomputing.tripfinder.Models.RequestTripObject;
import cloudcomputing.tripfinder.Models.ResponseObject;
import cloudcomputing.tripfinder.Models.Root;
import cloudcomputing.tripfinder.Models.TripIdResponse;
import cloudcomputing.tripfinder.Service.RandomNumberWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tripAdvisor")
public class controller {

    private RandomNumberWeatherService randomNumberWeatherService;

    public controller(RandomNumberWeatherService randomNumberWeatherService) {
        this.randomNumberWeatherService = randomNumberWeatherService;
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

}
