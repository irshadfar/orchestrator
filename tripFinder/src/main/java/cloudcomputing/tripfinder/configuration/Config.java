package cloudcomputing.tripfinder.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ConfigurationProperties
@NoArgsConstructor
@Getter
@Setter
public class Config {
    //get urls for external APIs
    @Value("${random-id-service.url}")
    private String randomIdServiceUrl;
    @Value("${weather-forecast-service.url}")
    private String weatherForecastServiceUrl;

    public String getRandomIdServiceUrl() {
        return randomIdServiceUrl;
    }

    public void setRandomIdServiceUrl(String randomIdServiceUrl) {
        this.randomIdServiceUrl = randomIdServiceUrl;
    }

    public String getWeatherForecastServiceUrl() {
        return weatherForecastServiceUrl;
    }

    public void setWeatherForecastServiceUrl(String weatherForecastServiceUrl) {
        this.weatherForecastServiceUrl = weatherForecastServiceUrl;
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
