package nyc.c4q.techup.mainui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.asyncexample.ExampleAsyncTasksActivity;
import nyc.c4q.techup.appexamples.fragmentsexample.ExampleFragmentsMainActivity;
import nyc.c4q.techup.appexamples.intentsexample.ExampleIntentsActivity;
import nyc.c4q.techup.appexamples.jsonparsingexample.ExampleJsonParsingActivity;
import nyc.c4q.techup.appexamples.menusexample.ExampleMenuActivity;
import nyc.c4q.techup.appexamples.recyclerviewexample.ExampleRecyclerViewActivity;
import nyc.c4q.techup.appexamples.retrofitexample.ExampleRetrofitActivity;
import nyc.c4q.techup.appexamples.sharedpreferencesexample.ExampleSharedPreferencesActivity;

public class AndroidExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_examples);
        //TODO: Recycler View!!! too many buttons, this isn't pretty!
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.button_asyctasks_intent:
                Intent asyncIntent = new Intent(AndroidExamplesActivity.this, ExampleAsyncTasksActivity.class);
                startActivity(asyncIntent);
                break;
            case R.id.button_fragments_intent:
                Intent fragmentIntent = new Intent(AndroidExamplesActivity.this, ExampleFragmentsMainActivity.class);
                startActivity(fragmentIntent);
                break;
            case R.id.button_intents_intent:
                Intent intentsIntent = new Intent(AndroidExamplesActivity.this, ExampleIntentsActivity.class);
                startActivity(intentsIntent);
                break;
            case R.id.button_menu_intent:
                Intent menuIntent = new Intent(AndroidExamplesActivity.this, ExampleMenuActivity.class);
                startActivity(menuIntent);
                break;
            case R.id.button_recyclerview_intent:
                Intent recyclerViewIntent = new Intent(AndroidExamplesActivity.this, ExampleRecyclerViewActivity.class);
                startActivity(recyclerViewIntent);
                break;
            case R.id.button_sharedpreferences_intent:
                Intent sharedPreferencesIntent = new Intent(AndroidExamplesActivity.this, ExampleSharedPreferencesActivity.class);
                startActivity(sharedPreferencesIntent);
                break;
            case R.id.button_retrofit_intent:
                Intent retrofitIntent = new Intent(AndroidExamplesActivity.this, ExampleRetrofitActivity.class);
                startActivity(retrofitIntent);
                break;
            case R.id.button_jsonparse_intent:
                Intent jsonIntent = new Intent(AndroidExamplesActivity.this, ExampleJsonParsingActivity.class);
                startActivity(jsonIntent);
                break;

        }
    }
}
