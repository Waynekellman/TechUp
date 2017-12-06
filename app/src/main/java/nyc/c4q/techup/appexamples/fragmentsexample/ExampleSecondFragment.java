package nyc.c4q.techup.appexamples.fragmentsexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.techup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleSecondFragment extends Fragment {

    View rootView;
    TextView textView;
    Bundle bundle;
    public ExampleSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.example_fragment_second, container, false);
        textView = (TextView) rootView.findViewById(R.id.second_fragment_textview);
        bundle = getArguments();
        textView.setText(bundle.getString("getEditText"));
        return rootView;
    }

}
