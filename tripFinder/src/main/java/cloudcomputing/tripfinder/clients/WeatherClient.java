package cloudcomputing.tripfinder.clients;

import cloudcomputing.tripfinder.Models.RequestTripObject;
import cloudcomputing.tripfinder.Models.Root;
import cloudcomputing.tripfinder.configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherClient {

    private final RestTemplate restTemplate;
    private final Config config;

    @Autowired
    public WeatherClient(RestTemplateBuilder restTemplateBuilder,
                             Config config) {
        this.restTemplate = restTemplateBuilder.build();
        this.config = config;
    }

    /**
     * getweatherInfo - method to get weather details
     * */
    public Root getWeatherInfo(RequestTripObject requestTripObject){
        String baseUrl = config.getWeatherForecastServiceUrl();
        String finalUrl = createFinalUrl(baseUrl, requestTripObject);

        Root response = new Root();
        response = restTemplate.getForObject(finalUrl, Root.class);

        return response;
    }

    /**
     * createFinalUrl - this method creates the final url and parameters for weather api
     * */
    private String createFinalUrl(String baseUrl, RequestTripObject requestTripObject) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("key","162e69cab2da4f16b0c185535240601" )
                .queryParam("q",requestTripObject.getLocation().replaceAll(" ","+"))
                .queryParam("format", "JSON")
                .queryParam("date", requestTripObject.getDateTime())
                .build().toString();

    }
}
