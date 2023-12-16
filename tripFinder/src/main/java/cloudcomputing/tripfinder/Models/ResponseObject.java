package cloudcomputing.tripfinder.Models;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class ResponseObject {

    private int userId;
    private int tripId;
    private String location;
    private String dateTime;
    private ArrayList<Weather> weather;

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public int getUserId() {
        return userId;
    }
    public int getTripId() {
        return tripId;
    }
    public String getLocation() {
        return location;
    }
    public String getDateTime() {
        return dateTime;
    }
    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }


}
