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

public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    Button mButtonStart;
    FragmentManager fragmentManager= getFragmentManager();
    String difficulty;

    final static String FUTURE_TAG="future destination";
    final static int ALLEY=0;
    final static int ROOM=1;
    final static int WIN=2;
    final static int LOST=3;
    final static String DIFFICULTY = "difficulty_preference";



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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_start:
                start();
                break;
            default:
                getDifficultyPreference();

                int winner;
                int looser;

                switch (difficulty) {
                    case "Easy":
                        winner = 3;
                        looser = 8;
                        break;
                    case "Medium":
                        winner = 2;
                        looser = 7;
                        break;
                    default:
                        winner = 1;
                        looser = 6;
                        break;
                }

                break;
        }
    }


    private void getDifficultyPreference () {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            difficulty = sharedPreferences.getString(DIFFICULTY, "Medium");
    }


    private void start() {
        if (new Random().nextInt(2)== 0){
            fragmentManager.beginTransaction().
                    replace(R.id.frame_main, new AlleyFragment()).addToBackStack(null).commit();
        }else{
            fragmentManager.beginTransaction().
                    replace(R.id.frame_main, new RoomFragment()).addToBackStack(null).commit();
        }
    }
}

