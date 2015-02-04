package co.mobilemakers.chooseyouradventuredinamic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlleyFragment extends Fragment {
    Button mButtonGoLeft;
    Button mButtonGoRight;
    Button mButtonContinue;


    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_alley, container, false);
        prepareButtons(rootView);
        return rootView;
    }

    private void prepareButtons(View rootView) {
        mButtonGoLeft=(Button) rootView.findViewById(R.id.button_go_left);
        mButtonContinue=(Button) rootView.findViewById(R.id.button_continue);
        mButtonGoRight=(Button) rootView.findViewById(R.id.button_go_right);
        mButtonGoLeft.setOnClickListener((View.OnClickListener)getActivity());
        mButtonContinue.setOnClickListener((View.OnClickListener)getActivity());
        mButtonGoRight.setOnClickListener((View.OnClickListener)getActivity());
    }
}
