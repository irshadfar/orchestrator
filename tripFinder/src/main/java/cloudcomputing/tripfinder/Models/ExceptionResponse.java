package cloudcomputing.tripfinder.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

    private String timeStamp;
    private int status;
    private String error;
}
