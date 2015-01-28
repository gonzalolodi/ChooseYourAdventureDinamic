package co.mobilemakers.chooseyouradventuredinamic;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
        if (getIntent().getExtras()==null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().
                    add(R.id.frame_main, new StartFragment()).commit();
        }else{
            int future= getIntent().getIntExtra(FUTURE_TAG,0);
            switch (future){
                case ALLEY:
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().
                            add(R.id.frame_main, new AlleyFragment()).commit();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

