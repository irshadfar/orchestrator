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

    private Config config;
    private RestTemplate restTemplate;

    public RandomNumberGeneratorClient(Config config, RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
    }

    public String generateRandomNumber(){
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getRandomIdServiceUrl());
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<List> forEntity = restTemplate.getForEntity(builder.toUriString(), List.class);

        return forEntity.getBody().get(0).toString();
    }
}
