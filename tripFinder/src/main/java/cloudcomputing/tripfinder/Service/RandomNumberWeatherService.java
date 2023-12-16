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


    private RandomNumberGeneratorClient randomNumberGeneratorClient;
    private WeatherClient weatherClient;

    @Autowired
    public RandomNumberWeatherService(RandomNumberGeneratorClient randomNumberGeneratorClient, WeatherClient weatherClient) {
        this.randomNumberGeneratorClient = randomNumberGeneratorClient;
        this.weatherClient = weatherClient;
    }

    public TripIdResponse generateTripAndUserID(){
        TripIdResponse tripIdResponse = new TripIdResponse();

        String userId = randomNumberGeneratorClient.generateUserId();
        String tripId = randomNumberGeneratorClient.generateTripId();

        tripIdResponse.setUserID(userId);
        tripIdResponse.setTripID(tripId);

        return tripIdResponse;
    }
    public ResponseObject getTripData(RequestTripObject requestTripObject){

        ResponseObject responseObject = new ResponseObject();
        Root root = weatherClient.getWeatherInfo(requestTripObject);

        responseObject.setTripId(requestTripObject.getTripId());
        responseObject.setUserId(requestTripObject.getUserId());
        responseObject.setLocation(requestTripObject.getLocation());
        responseObject.setDateTime(requestTripObject.getDateTime());
        responseObject.setWeather(root.getData().getWeather());

        return  responseObject;
    }
}
