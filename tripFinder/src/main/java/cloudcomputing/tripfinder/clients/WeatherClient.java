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
    private Config config;

    @Autowired
    public WeatherClient(RestTemplateBuilder restTemplateBuilder,
                             Config config) {
        this.restTemplate = restTemplateBuilder.build();
        this.config = config;
    }

    public Root getWeatherInfo(RequestTripObject requestTripObject){
        String baseUrl = config.getWeatherForecastServiceUrl();
        String finalUrl = createFinalUrl(baseUrl, requestTripObject);

        Root response = new Root();
        response = restTemplate.getForObject(finalUrl, Root.class);

        return response;
    }

    private String createFinalUrl(String baseUrl, RequestTripObject requestTripObject) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("key","57e1df18065a486babb180350230412" )
                .queryParam("q",requestTripObject.getLocation().replaceAll(" ","+"))
                .queryParam("format", "JSON")
                .queryParam("date", requestTripObject.getDateTime())
                .build().toString();

    }
}
