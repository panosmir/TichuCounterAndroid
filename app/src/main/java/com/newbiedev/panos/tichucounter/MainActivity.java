package com.newbiedev.panos.tichucounter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initiate FragmentManager. It's responsible for fragment initiation.
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentTransaction allow us to call methods for fragments.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Init our two fragments. The PlayFragment which contains the Checkboxes etc.
        //And the MainFragment that it's for the main screen of the app.
        PlayFragment _playFragment = (PlayFragment) fragmentManager.findFragmentById(R.id.play_fragment_container);
        MainFragment _mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.main_fragment_container);

        //OnCreate we want to show the MainFragment and hide the PlayFragment.
        fragmentTransaction.show(_mainFragment);
        fragmentTransaction.hide(_playFragment);

        //Committing our changes.
        fragmentTransaction.commit();

    }

    public void newGameButtonClick(View view) {

        /*Every time we want to make a FragmentTransaction in different methods
        we must initiate a new FragmentTransaction and and beginTransaction of FragmentManager that
        we already initiate.*/
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlayFragment playFragment = (PlayFragment) fragmentManager.findFragmentById(R.id.play_fragment_container);
        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.main_fragment_container);

        //addToBackStack let us go back if we press the back button.
        //NULL because we don't have/need any parameter we going back.
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.show(playFragment);
        fragmentTransaction.hide(mainFragment);
        fragmentTransaction.commit();

    }

    public void playButtonClick(View view){

    }

    public void changeTeamANameButton(View view){
        /*Change the visibility of the components to be right*/

        TextView _teamATextView = (TextView)findViewById(R.id.TextViewTeamA);
        _teamATextView.setVisibility(View.INVISIBLE);

        EditText _teamAEditText = (EditText)findViewById(R.id.editTextTeamA);
        _teamAEditText.setVisibility(View.VISIBLE);

        ImageButton _resetNameButton = (ImageButton)findViewById(R.id.resetNamesButton);
        _resetNameButton.setVisibility(View.INVISIBLE);

        ImageButton _saveNamesButton = (ImageButton)findViewById(R.id.saveNameButton);
        _saveNamesButton.setVisibility(View.VISIBLE);
    }

    public void saveNamesButtonClick(View view){
        //init the xml components
        TextView _teamATextView = (TextView)findViewById(R.id.TextViewTeamA);
        //set the visibility to be visible
        _teamATextView.setVisibility(View.VISIBLE);

        EditText _teamAEditText = (EditText)findViewById(R.id.editTextTeamA);
        _teamAEditText.setVisibility(View.INVISIBLE);

        //Change the TeamATextView text with whatever the teamAEditText contains
        _teamATextView.setText(_teamAEditText.getText());

        //And then make the buttons invisible and visible
        ImageButton _resetNameButton = (ImageButton)findViewById(R.id.resetNamesButton);
        _resetNameButton.setVisibility(View.VISIBLE);

        ImageButton _saveNamesButton = (ImageButton)findViewById(R.id.saveNameButton);
        _saveNamesButton.setVisibility(View.INVISIBLE);
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
                //Init an Intent and connect it with AboutActivity
                Intent intent = new Intent(this, AboutActivity.class);
                //Start the Activity and then it'll get it from AboutActivity.java
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
