package nyc.c4q.techup.mainui.guidefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.techup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicDetailsFragment extends Fragment {


    public TopicDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic_details, container, false);
    }

}
