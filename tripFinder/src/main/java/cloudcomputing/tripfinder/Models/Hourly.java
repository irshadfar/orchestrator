package cloudcomputing.tripfinder.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Hourly {
    public String time;
    public String tempC;
    public String tempF;
    public String windspeedMiles;
    public String windspeedKmph;
    public String winddirDegree;
    public String winddir16Point;
    public String weatherCode;
    public ArrayList<WeatherIconUrl> weatherIconUrl;
    public ArrayList<WeatherDesc> weatherDesc;
    public String precipMM;
    public String precipInches;
    public String humidity;
    public String visibility;
    public String visibilityMiles;
    public String pressure;
    public String pressureInches;
    public String cloudcover;
    @JsonProperty("HeatIndexC")
    public String heatIndexC;
    @JsonProperty("HeatIndexF")
    public String heatIndexF;
    @JsonProperty("DewPointC")
    public String dewPointC;
    @JsonProperty("DewPointF")
    public String dewPointF;
    @JsonProperty("WindChillC")
    public String windChillC;
    @JsonProperty("WindChillF")
    public String windChillF;
    @JsonProperty("WindGustMiles")
    public String windGustMiles;
    @JsonProperty("WindGustKmph")
    public String windGustKmph;
    @JsonProperty("FeelsLikeC")
    public String feelsLikeC;
    @JsonProperty("FeelsLikeF")
    public String feelsLikeF;
    public String chanceofrain;
    public String chanceofremdry;
    public String chanceofwindy;
    public String chanceofovercast;
    public String chanceofsunshine;
    public String chanceoffrost;
    public String chanceofhightemp;
    public String chanceoffog;
    public String chanceofsnow;
    public String chanceofthunder;
    public String uvIndex;
}
