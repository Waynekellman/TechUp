package nyc.c4q.techup.appexamples.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    NYTAdapter nytAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_retrofit);

        recyclerView = (RecyclerView) findViewById(R.id.nyt_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        nytAdapter = new NYTAdapter(articleList);
        recyclerView.setAdapter(nytAdapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        ExampleRetrofitService service = retrofit.create(ExampleRetrofitService.class);
        Call<NYTResponse> call = service.getResponse(apiKey);
        call.enqueue(new retrofit2.Callback<NYTResponse>() {
            @Override
            public void onResponse(Call<NYTResponse> call, retrofit2.Response<NYTResponse> response) {

                NYTDoc nytDoc = response.body().getResponse();
                Log.d(TAG, "onResponse: " + nytDoc.getDocs().length);

                for (int i = 0; i<nytDoc.getDocs().length ; i++){
                    NYTArticle article = new NYTArticle();
                    article.setSnippet(nytDoc.getDocs()[i].getSnippet());
                    article.setHeadline(nytDoc.getDocs()[i].getHeadline());

                    Log.e("Retrofit", article.getSnippet());
                    articleList.add(article);
                    nytAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NYTResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    public void connectWithRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        ExampleRetrofitService service = retrofit.create(ExampleRetrofitService.class);
        Call<NYTResponse> call = service.getResponse(apiKey);
        call.enqueue(new retrofit2.Callback<NYTResponse>() {
            @Override
            public void onResponse(Call<NYTResponse> call, retrofit2.Response<NYTResponse> response) {

                    NYTDoc nytDoc = response.body().getResponse();
                    Log.d(TAG, "onResponse: " + nytDoc.getDocs().length);

                    for (int i = 0; i<nytDoc.getDocs().length ; i++){
                        NYTArticle article = new NYTArticle();
                             article.setSnippet(nytDoc.getDocs()[i].getSnippet());
                             article.setHeadline(nytDoc.getDocs()[i].getHeadline());

                             Log.e("Retrofit", article.getSnippet());
                        articleList.add(article);
                    }

            }

            @Override
            public void onFailure(Call<NYTResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
