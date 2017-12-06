package nyc.c4q.techup.appexamples.intentsexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nyc.c4q.techup.R;

public class ExampleIntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_intents);
    }
    public void openExplicitIntent(View v){
        Intent intent = new Intent(ExampleIntentsActivity.this, ExampleSecondIntentActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "hello world text");
        intent.putExtra("somekey", "somevalue");

        startActivity(intent);
    }
    public void openImplicitIntent(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://c4q.nyc"));//opens web
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello world share me");
        //Intent intent = new Intent(Intent.ACTION_SEND);//for sharing

        //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//opens camera
        //startActivity(intent);*/
        //int requestCode = 0;//when you start actiity that calls function, add a request code to identify who is calling method(implicit, explicit
        //startActivityForResult(intent, requestCode);//this activity will give us something back
        startActivity(intent);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //handle data returned -
        //how does new intent get data from previous intent? something called extras- complex data, not something you can put in one string

        if (requestCode==0){
            //this is implicit- result code is used by the intent you launched resultCOde is set by requestCode?
            //helps program figure out what to do with results. Data is in intent data
        }
    }
}
