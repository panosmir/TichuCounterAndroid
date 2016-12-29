package com.newbiedev.panos.tichucounter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlayFragment _playFragment = (PlayFragment) fragmentManager.findFragmentById(R.id.play_fragment_container);
        MainFragment _mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.main_fragment_container);


        fragmentTransaction.show(_mainFragment);
        fragmentTransaction.hide(_playFragment);

        fragmentTransaction.commit();

    }

    public void newGameButtonClick(View view) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlayFragment playFragment = (PlayFragment) fragmentManager.findFragmentById(R.id.play_fragment_container);
        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.main_fragment_container);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.show(playFragment);
        fragmentTransaction.hide(mainFragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newGameButton:
                //something
                return true;
            case R.id.undoButton:
                //something
                return true;
            case R.id.aboutButton:
                //something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
