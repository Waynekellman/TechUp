package nyc.c4q.techup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nyc.c4q.techup.mainui.AndroidExamplesActivity;
import nyc.c4q.techup.mainui.AndroidGuideActivity;
import nyc.c4q.techup.mainui.AndroidTermsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonclick(View view){
        switch(view.getId()) {
            case R.id.button_development_guides_intent:
                Intent guidesIntent = new Intent(MainActivity.this, AndroidGuideActivity.class);
                startActivity(guidesIntent);
                break;
            case R.id.button_example_apps_intent:
                Intent examplesIntent = new Intent(MainActivity.this, AndroidExamplesActivity.class);
                startActivity(examplesIntent);
                break;
            case R.id.button_terminology_intent:
                Intent terminologyIntent = new Intent(MainActivity.this, AndroidTermsActivity.class);
                startActivity(terminologyIntent);
                break;
        }
    }
}
