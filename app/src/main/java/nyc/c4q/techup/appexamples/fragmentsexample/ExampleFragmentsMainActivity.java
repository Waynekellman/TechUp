package nyc.c4q.techup.appexamples.fragmentsexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.techup.R;

public class ExampleFragmentsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_fragments);

        ExampleFirstFragment exampleFirstFragment = new ExampleFirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_container_framelayout, exampleFirstFragment);
        fragmentTransaction.commit();
    }
}
