package cloudcomputing.tripfinder.clients;

import cloudcomputing.tripfinder.configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class RandomNumberGeneratorClient {

    private final Config config;
    private final RestTemplate restTemplate;

    public RandomNumberGeneratorClient(Config config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * generateUserId - this method is used to call random numger generator api to get unique user id
     * */
    public String generateUserId(){

        //creating the final url to call random generator API
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getRandomIdServiceUrl())
                .queryParam("min", "1000")
                .queryParam("max", "10000")
                .queryParam("count", "1");

        //creating header and accept data in json format
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List> forEntity = restTemplate.getForEntity(builder.toUriString(), List.class);

        return forEntity.getBody().get(0).toString();
    }

    /**
     * generateTripId - this method is used to call random numger generator api to get unique trip id
     * */
    public String generateTripId(){

        //creating the final url to call random generator API
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getRandomIdServiceUrl())
                .queryParam("min", "10000")
                .queryParam("max", "100000")
                .queryParam("count", "1");

        //creating header and accept respone type as json
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List> forEntity = restTemplate.getForEntity(builder.toUriString(), List.class);

        return forEntity.getBody().get(0).toString();
    }
}
