package nyc.c4q.techup.appexamples.fragmentsexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.techup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFirstFragment extends Fragment {
    View rootView;
    EditText editText;
    Button button;
    CheckingInputs response;


    public ExampleFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView =  inflater.inflate(R.layout.example_fragment_first, container, false);
        editText = (EditText) rootView.findViewById(R.id.example_first_fragment_editText);
        button = (Button) rootView.findViewById(R.id.first_fragment_button);
        String userEntry = editText.getText().toString();
        response = new CheckingInputs(userEntry);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEntry = editText.getText().toString();
                response = new CheckingInputs(userEntry);
                ExampleSecondFragment secondFragment = new ExampleSecondFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("getEditText", response.responses());
                secondFragment.setArguments(bundle);
                fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                fragmentTransaction.replace(R.id.main_fragment_container_framelayout, secondFragment);
                fragmentTransaction.addToBackStack("next");
                fragmentTransaction.commit();

            }
        });
       return rootView;

    }

}
