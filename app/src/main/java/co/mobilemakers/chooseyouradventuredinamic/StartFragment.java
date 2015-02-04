package co.mobilemakers.chooseyouradventuredinamic;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class StartFragment extends Fragment {
    Button mButtonStart;

    public StartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        prepareButton(rootView);
        return rootView;

    }

    private void prepareButton(View rootView) {
        mButtonStart= (Button) rootView.findViewById(R.id.button_start);
        mButtonStart.setOnClickListener((View.OnClickListener)getActivity());
    }
}
