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
public class RoomFragment extends Fragment {
    Button mButtonDoor1;
    Button mButtonDoor2;


    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_room, container, false);
        prepareButtons(rootView);
        return rootView;
    }

    private void prepareButtons(View rootView) {
        mButtonDoor1= (Button) rootView.findViewById(R.id.button_door1);
        mButtonDoor2= (Button) rootView.findViewById(R.id.button_door2);
        mButtonDoor1.setOnClickListener((View.OnClickListener)getActivity());
        mButtonDoor2.setOnClickListener((View.OnClickListener)getActivity());
    }


}
