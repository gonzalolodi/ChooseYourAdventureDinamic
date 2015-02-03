package co.mobilemakers.chooseyouradventuredinamic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends ActionBarActivity {
    Button mButtonStart;

    final static String FUTURE_TAG="future destination";
    final static int ALLEY=0;
    final static int ROOM=1;
    final static int WIN=2;
    final static int LOST=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();

        if (getIntent().getExtras()==null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().
                    add(R.id.frame_main, new StartFragment()).commit();
        }else{
            int future= getIntent().getIntExtra(FUTURE_TAG,0);
            FragmentManager fragmentManager = getFragmentManager();
            switch (future){
                case ALLEY:
                    fragmentManager.beginTransaction().
                            add(R.id.frame_main, new AlleyFragment()).commit();
                    break;
                case ROOM:
                    fragmentManager.beginTransaction().
                            add(R.id.frame_main, new RoomFragment()).commit();
                    break;
                case WIN:
                    fragmentManager.beginTransaction().
                            add(R.id.frame_main, new WinnerFragment()).commit();
                    break;
                case LOST:
                    fragmentManager.beginTransaction().
                            add(R.id.frame_main, new LooserFragment()).commit();
                    break;



            }
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}

