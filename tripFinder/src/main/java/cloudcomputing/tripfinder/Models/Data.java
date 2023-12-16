package cloudcomputing.tripfinder.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Data {
    public ArrayList<Request> request;
    public ArrayList<CurrentCondition> current_condition;
    public ArrayList<Weather> weather;
    @JsonProperty("ClimateAverages")
    public ArrayList<ClimateAverage> climateAverages;

    public ArrayList<Request> getRequest() {
        return request;
    }

    public void setRequest(ArrayList<Request> request) {
        this.request = request;
    }

    public ArrayList<CurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(ArrayList<CurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public ArrayList<ClimateAverage> getClimateAverages() {
        return climateAverages;
    }

    public void setClimateAverages(ArrayList<ClimateAverage> climateAverages) {
        this.climateAverages = climateAverages;
    }
}
