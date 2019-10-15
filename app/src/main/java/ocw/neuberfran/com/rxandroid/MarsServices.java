package ocw.neuberfran.com.rxandroid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarsServices {

    String MARS_API_BASE_URL = "http://marsweather.ingenology.com/v1/";

    @GET("latest")
    Call < MarsReport > latest();

}