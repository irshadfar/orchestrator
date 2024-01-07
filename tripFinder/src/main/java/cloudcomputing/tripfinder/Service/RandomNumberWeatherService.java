package cloudcomputing.tripfinder.Service;

import cloudcomputing.tripfinder.Models.RequestTripObject;
import cloudcomputing.tripfinder.Models.ResponseObject;
import cloudcomputing.tripfinder.Models.Root;
import cloudcomputing.tripfinder.Models.TripIdResponse;
import cloudcomputing.tripfinder.clients.RandomNumberGeneratorClient;
import cloudcomputing.tripfinder.clients.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberWeatherService {

    private final RandomNumberGeneratorClient randomNumberGeneratorClient;
    private final WeatherClient weatherClient;

    @Autowired
    public RandomNumberWeatherService(RandomNumberGeneratorClient randomNumberGeneratorClient, WeatherClient weatherClient) {
        this.randomNumberGeneratorClient = randomNumberGeneratorClient;
        this.weatherClient = weatherClient;
    }

    /**
     * generateTripAndUserID - this method is used to call gather the user id and trip is in one response
     * */
    public TripIdResponse generateTripAndUserID(){
        TripIdResponse tripIdResponse = new TripIdResponse();

        String userId = randomNumberGeneratorClient.generateUserId();
        String tripId = randomNumberGeneratorClient.generateTripId();

        //setting user id and trip is into one response
        tripIdResponse.setUserID(userId);
        tripIdResponse.setTripID(tripId);

        return tripIdResponse;
    }

    /**
     * getTripData - this method is used to get the weather details
     * */
    public ResponseObject getTripData(RequestTripObject requestTripObject){

        ResponseObject responseObject = new ResponseObject();
        Root root = weatherClient.getWeatherInfo(requestTripObject);

        // setting the response to return to front end
        responseObject.setTripId(requestTripObject.getTripId());
        responseObject.setUserId(requestTripObject.getUserId());
        responseObject.setLocation(requestTripObject.getLocation());
        responseObject.setDateTime(requestTripObject.getDateTime());
        responseObject.setWeather(root.getData().getWeather());

        return  responseObject;
    }
}
