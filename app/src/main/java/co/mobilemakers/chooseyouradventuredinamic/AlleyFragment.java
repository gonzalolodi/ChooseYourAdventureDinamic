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
public class AlleyFragment extends Fragment {
    Button mButtonGoLeft;
    Button mButtonGoRight;
    Button mButtonContinue;
    Boolean mWinner;


    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alley, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareButtons();
    }
    private void prepareButtons() {
        mButtonGoLeft=(Button) getView().findViewById(R.id.button_go_left);
        mButtonContinue=(Button) getView().findViewById(R.id.button_continue);
        mButtonGoRight=(Button) getView().findViewById(R.id.button_go_right);
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
        mButtonGoLeft.setOnClickListener(buttonsListener);
        mButtonContinue.setOnClickListener(buttonsListener);
        mButtonGoRight.setOnClickListener(buttonsListener);
    }
}
