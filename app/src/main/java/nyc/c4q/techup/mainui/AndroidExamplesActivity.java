package nyc.c4q.techup.mainui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.asyncexample.ExampleAsyncTasksActivity;
import nyc.c4q.techup.appexamples.fragmentsexample.ExampleFragmentsMainActivity;
import nyc.c4q.techup.appexamples.intentsexample.ExampleIntentsActivity;
import nyc.c4q.techup.appexamples.jsonparsingexample.ExampleJsonParsingActivity;
import nyc.c4q.techup.appexamples.menusexample.ExampleMenuActivity;
import nyc.c4q.techup.appexamples.recyclerviewexample.ExampleRecyclerViewActivity;
import nyc.c4q.techup.appexamples.retrofitexample.ExampleRetrofitActivity;
import nyc.c4q.techup.appexamples.sharedpreferencesexample.ExampleSharedPreferencesActivity;
import nyc.c4q.techup.mainui.examplesmainui.ExampleCardAdapter;
import nyc.c4q.techup.mainui.examplesmainui.ExampleCardData;


public class AndroidExamplesActivity extends AppCompatActivity {

    private View.OnClickListener exampleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView title = view.findViewById(R.id.example_card_title_textview);
            String name = (String) title.getTag();
            switch (name) {
                case "asyncTasks":
                    Intent asyncIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleAsyncTasksActivity.class);
                    startActivity(asyncIntent);
                    break;
                case "fragments":
                    Intent fragmentIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleFragmentsMainActivity.class);
                    startActivity(fragmentIntent);
                    break;
                case "intents":
                    Intent intentsIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleIntentsActivity.class);
                    startActivity(intentsIntent);
                    break;
                case "menus":
                    Intent menuIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleMenuActivity.class);
                    startActivity(menuIntent);
                    break;
                case "recyclerView":
                    Intent recyclerViewIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleRecyclerViewActivity.class);
                    startActivity(recyclerViewIntent);
                    break;
                case "sharedPreferences":
                    Intent sharedPreferencesIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleSharedPreferencesActivity.class);
                    startActivity(sharedPreferencesIntent);
                    break;
                case "retrofit":
                    Intent retrofitIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleRetrofitActivity.class);
                    startActivity(retrofitIntent);
                    break;
                case "jsonParsing":
                    Intent jsonIntent = new Intent(AndroidExamplesActivity.this,
                            ExampleJsonParsingActivity.class);
                    startActivity(jsonIntent);
                    break;
            }
        }
    };

    RecyclerView recyclerView;
    ExampleCardData exampleCardList;
    ExampleCardAdapter exampleCardAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_examples);
        //TODO: Recycler View!!! too many buttons, this isn't pretty!

        exampleCardList = new ExampleCardData();
        exampleCardList.setContext(getApplicationContext());
        exampleCardList = exampleCardList.setExampleCardList();
        exampleCardAdapter = new ExampleCardAdapter(exampleCardList, exampleClickListener);
        setRecyclerView();

    }

    public void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.example_card_recycler_view);
        exampleCardAdapter.notifyDataSetChanged();
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(exampleCardAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
