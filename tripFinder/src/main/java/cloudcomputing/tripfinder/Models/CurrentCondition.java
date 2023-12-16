package cloudcomputing.tripfinder.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CurrentCondition {
    public String observation_time;
    public String temp_C;
    public String temp_F;
    public String weatherCode;
    public ArrayList<WeatherIconUrl> weatherIconUrl;
    public ArrayList<WeatherDesc> weatherDesc;
    public String windspeedMiles;
    public String windspeedKmph;
    public String winddirDegree;
    public String winddir16Point;
    public String precipMM;
    public String precipInches;
    public String humidity;
    public String visibility;
    public String visibilityMiles;
    public String pressure;
    public String pressureInches;
    public String cloudcover;
    @JsonProperty("FeelsLikeC")
    public String feelsLikeC;
    @JsonProperty("FeelsLikeF")
    public String feelsLikeF;
    public String uvIndex;
}
