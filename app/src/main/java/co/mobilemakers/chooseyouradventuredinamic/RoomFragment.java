package co.mobilemakers.chooseyouradventuredinamic;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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
        return inflater.inflate(R.layout.fragment_room, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareButtons();
    }
    private void prepareButtons() {
        mButtonDoor1= (Button) getView().findViewById(R.id.button_door1);
        mButtonDoor2= (Button) getView().findViewById(R.id.button_door2);
        View.OnClickListener buttonsListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random= new Random();
                int future= random.nextInt(4);
                Intent futureDestination= new Intent(getActivity(),MainActivity.class);
                futureDestination.putExtra(MainActivity.FUTURE_TAG,future);
                startActivity(futureDestination);
            }
        };
        mButtonDoor1.setOnClickListener(buttonsListener);
        mButtonDoor2.setOnClickListener(buttonsListener);
    }


}
