package cloudcomputing.tripfinder.Models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestTripObject {
    private int userId;
    private int tripId;
    private String location;
    private String dateTime;

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
}
