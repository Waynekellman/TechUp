package nyc.c4q.techup.appexamples.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.retrofitexample.controller.NYTAdapter;
import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTArticle;
import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTDoc;
import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExampleRetrofitActivity extends AppCompatActivity {
    String apiKey = "8b162b0c4f9b4342874bb91662ab6b98";
    String baseURL = "https://api.nytimes.com/svc/";
    String endPoint = "search/v2/articlesearch.json";
    RecyclerView recyclerView;

   List<NYTArticle> articleList = new ArrayList<>();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_retrofit);

        connectWithRetrofit();
        recyclerView = (RecyclerView) findViewById(R.id.nyt_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        NYTAdapter nytAdapter = new NYTAdapter(articleList);
        recyclerView.setAdapter(nytAdapter);
    }

    public void connectWithRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        ExampleRetrofitService service = retrofit.create(ExampleRetrofitService.class);
        Call<NYTResponse> call = service.getResponse(apiKey);
        call.enqueue(new retrofit2.Callback<NYTResponse>() {
            @Override
            public void onResponse(Call<NYTResponse> call, retrofit2.Response<NYTResponse> response) {
                try {
                    NYTDoc nytDoc = response.body().getResponse();
                    Log.d(TAG, "onResponse: " + nytDoc.getDocs().length);
                    articleList.addAll(Arrays.asList(nytDoc.getDocs()));
                }catch (NullPointerException n){
                    Log.d("Retrofit", "empty response");
                }
            }

            @Override
            public void onFailure(Call<NYTResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
