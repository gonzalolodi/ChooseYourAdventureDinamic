package co.mobilemakers.chooseyouradventuredinamic;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LooserFragment extends Fragment {

    String mPlayerName;
    TextView mFinalText;


    public LooserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_looser, container, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mPlayerName = sharedPreferences.getString(MainActivity.PLAYER_NAME, "Brave Fighter");
        mFinalText = (TextView) rootView.findViewById(R.id.text_view_looser);
        mFinalText.setText(String.format(getString(R.string.text_view_final_looser),mPlayerName));
        return rootView;
    }


}
