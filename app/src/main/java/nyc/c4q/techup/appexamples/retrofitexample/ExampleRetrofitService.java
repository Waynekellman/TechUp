package nyc.c4q.techup.appexamples.retrofitexample;

import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amirahoxendine on 12/19/17.
 */

public interface ExampleRetrofitService {

        @GET("search/v2/articlesearch.json")
        Call<NYTResponse> getResponse(@Query("api-key") String apiKey);

}
