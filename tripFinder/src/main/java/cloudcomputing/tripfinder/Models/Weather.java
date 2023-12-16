package cloudcomputing.tripfinder.Models;

import java.util.ArrayList;

public class Weather {
    public String date;
    public ArrayList<Astronomy> astronomy;
    public String maxtempC;
    public String maxtempF;
    public String mintempC;
    public String mintempF;
    public String avgtempC;
    public String avgtempF;
    public String totalSnow_cm;
    public String sunHour;
    public String uvIndex;
    public ArrayList<Hourly> hourly;
}
