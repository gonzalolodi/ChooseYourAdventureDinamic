package co.mobilemakers.chooseyouradventuredinamic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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
        return inflater.inflate(R.layout.fragment_start, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareButton();
    }

    private void prepareButton() {
        mButtonStart= (Button) getView().findViewById(R.id.button_start);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Random random= new Random();
                                                int future= random.nextInt(2);
                                                Intent futureDestination= new Intent(getActivity(),MainActivity.class);
                                                futureDestination.putExtra(MainActivity.FUTURE_TAG,future);
                                                startActivity(futureDestination);

                                            }
                                        }
        );
    }
}
