package nyc.c4q.techup.appexamples.menusexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



import nyc.c4q.techup.R;

public class ExampleMenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private Button contextButton;
    private final String TAG = getClass().getSimpleName();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        contextButton = (Button) findViewById(R.id.context_button);
        registerForContextMenu(contextButton);
        context = getApplicationContext();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        //return super.onCreateOptionsMenu(menu); if you want to create your menu conditionally? want to open menu only if...
        return true;// common patter calling super or return true.
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
    }
    //doesnt need to be overrided, because isnt displayed by default, displayed by events
    public void onCreatePopupMenu(View v) {
        android.widget.PopupMenu popup = new android.widget.PopupMenu(context, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(new android.widget.PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.search_item:
                        Log.e(TAG, "search was clicked");
                        break;
                    case R.id.feedback_item:
                        Log.e(TAG, "Feedback was clicked");
                        break;
                    case R.id.settings_item:
                        Log.e(TAG, "Settings was clicked");
                        break;
                    case R.id.help_item:
                        Log.e(TAG, "Popup: Help was clicked");
                        Intent helpIntent = new Intent(ExampleMenuActivity.this, ExampleSecondMenuActivity.class);
                        startActivity(helpIntent);
                        break;
                }
                return true;
            }
        });
        inflater.inflate(R.menu.example_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();// gts, googlt this shit
         /*switch (item.getItemId()) {
           case R.id.edit:
                editNote(info.id);
                return true;
            case R.id.delete:
                deleteNote(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);*/
        switch(item.getItemId()){
            case R.id.search_item:
                Log.e(TAG, "search was clicked");
                break;
            case R.id.feedback_item:
                Log.e(TAG, "Feedback was clicked");
                break;
            case R.id.settings_item:
                Log.e(TAG, "Settings was clicked");
                break;
            case R.id.help_item:
                Log.e(TAG, "Help was clicked");
                Intent helpIntent = new Intent(this, ExampleSecondMenuActivity.class);
                startActivity(helpIntent);
                break;
        }
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.search_item:
                Log.e(TAG, "search was clicked");
                break;
            case R.id.feedback_item:
                Log.e(TAG, "Feedback was clicked");
                break;
            case R.id.settings_item:
                Log.e(TAG, "Settings was clicked");
                break;
            case R.id.help_item:
                Log.e(TAG, "Help was clicked");
                Intent helpIntent = new Intent(this, ExampleSecondMenuActivity.class);
                startActivity(helpIntent);
                break;
        }
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.search_item:
                Log.e(TAG, "search was clicked");
                break;
            case R.id.feedback_item:
                Log.e(TAG, "Feedback was clicked");
                break;
            case R.id.settings_item:
                Log.e(TAG, "Settings was clicked");
                break;
            case R.id.help_item:
                Log.e(TAG, "Popup: Help was clicked");
                Intent helpIntent = new Intent(this, ExampleSecondMenuActivity.class);
                startActivity(helpIntent);
                break;
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
