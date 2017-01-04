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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initiate FragmentManager. It's responsible for fragment initiation.
    FragmentManager fragmentManager = getFragmentManager();
    Score score;
    List<Integer> scoreTeamA = new ArrayList<>();
    List<Integer> scoreTeamB = new ArrayList<>();
    ArrayAdapter<Integer> adapterA, adapterB;
    int tempA = 0, tempB = 0;
    String resultA, resultB;
    private boolean check = false;

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

        ListView scoreListA = (ListView) findViewById(R.id.ScoreListA);
        ListView scoreListB = (ListView) findViewById(R.id.ScoreListB);

        adapterA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scoreTeamA);
        adapterB = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scoreTeamB);

        scoreListA.setAdapter(adapterA);
        scoreListB.setAdapter(adapterB);

    }

    public void playButtonClick(View view) {

        EditText scoreA = (EditText) findViewById(R.id.scoreAEditText);
        EditText scoreB = (EditText) findViewById(R.id.scoreBEditText);

        CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
        CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);

        RadioButton tichuMadeA = (RadioButton)findViewById(R.id.tichuMadeA);
        RadioButton tichuLostA = (RadioButton)findViewById(R.id.tichuLostA);
        RadioButton gTichuMadeA = (RadioButton)findViewById(R.id.gTichuMadeA);
        RadioButton gTichuLostA = (RadioButton)findViewById(R.id.gTichuLostA);

        RadioButton tichuMadeB = (RadioButton)findViewById(R.id.tichuMadeB);
        RadioButton tichuLostB = (RadioButton)findViewById(R.id.tichuLostB);
        RadioButton gTichuMadeB = (RadioButton)findViewById(R.id.gTichuMadeB);
        RadioButton gTichuLostB = (RadioButton)findViewById(R.id.gTichuLostB);

        boolean hasPoints = false;

        if(scoreA.getText().toString().isEmpty() && scoreB.getText().toString().isEmpty()) {
            if (oneTwoA.isChecked() && !oneTwoB.isChecked()) {
                tempA = 200;
                scoreTeamA.add(tempA);
                scoreTeamB.add(tempB);
            } else if (!oneTwoA.isChecked() && oneTwoB.isChecked()) {
                tempB = 200;
                scoreTeamA.add(tempA);
                scoreTeamB.add(tempB);
            }
        }
        else if (scoreB.getText().toString().isEmpty() || scoreB.getText().equals("")){
            int sA = Integer.parseInt(scoreA.getText().toString());
            if (sA %5 == 0 && sA<=125 && sA>=-25){
                tempA = sA;
                tempB = 100 - tempA;
                if(tichuMadeA.isChecked())
                    tempA += 100;
                else if (tichuLostA.isChecked())
                    tempA -= 100;
                else if (gTichuMadeA.isChecked())
                    tempA += 200;
                else if (gTichuLostA.isChecked())
                    tempA -= 200;
                scoreTeamA.add(tempA);
                scoreTeamB.add(tempB);
            }
        }
        else if (scoreA.getText().toString().isEmpty() || scoreA.getText().equals("")){
            int sB = Integer.parseInt(scoreB.getText().toString());
            if(sB %5 == 0 && sB<=125 && sB>=-25){
                tempB = sB;
                tempA = 100 - tempB;
                if (tichuMadeB.isChecked())
                    tempB += 100;
                else if (tichuLostB.isChecked())
                    tempB -= 100;
                else if (gTichuMadeB.isChecked())
                    tempB += 200;
                else if (gTichuLostB.isChecked())
                    tempB -= 200;
                scoreTeamA.add(tempA);
                scoreTeamB.add(tempB);
            }
        }

        ClearFields();

        adapterA.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();

    }

//    private void initComponents(){
//        EditText scoreA = (EditText) findViewById(R.id.scoreAEditText);
//        EditText scoreB = (EditText) findViewById(R.id.scoreBEditText);
//
//        CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
//        CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);
//
//        RadioButton tichuMadeA = (RadioButton)findViewById(R.id.tichuMadeA);
//        RadioButton tichuLostA = (RadioButton)findViewById(R.id.tichuLostA);
//        RadioButton gTichuMadeA = (RadioButton)findViewById(R.id.gTichuMadeA);
//        RadioButton gTichuLostA = (RadioButton)findViewById(R.id.gTichuLostA);
//
//        RadioButton tichuMadeB = (RadioButton)findViewById(R.id.tichuMadeB);
//        RadioButton tichuLostB = (RadioButton)findViewById(R.id.tichuLostB);
//        RadioButton gTichuMadeB = (RadioButton)findViewById(R.id.gTichuMadeB);
//        RadioButton gTichuLostB = (RadioButton)findViewById(R.id.gTichuLostB);
//    }

    public void checked(View view){
        if(!check)
            check = true;
        else
            check = false;
    }

    private void ClearFields(){

        EditText scoreA = (EditText) findViewById(R.id.scoreAEditText);
        EditText scoreB = (EditText) findViewById(R.id.scoreBEditText);

        CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
        CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);

//        RadioButton tichuMadeA = (RadioButton)findViewById(R.id.tichuMadeA);
//        RadioButton tichuLostA = (RadioButton)findViewById(R.id.tichuLostA);
//        RadioButton gTichuMadeA = (RadioButton)findViewById(R.id.gTichuMadeA);
//        RadioButton gTichuLostA = (RadioButton)findViewById(R.id.gTichuLostA);
//
//        RadioButton tichuMadeB = (RadioButton)findViewById(R.id.tichuMadeB);
//        RadioButton tichuLostB = (RadioButton)findViewById(R.id.tichuLostB);
//        RadioButton gTichuMadeB = (RadioButton)findViewById(R.id.gTichuMadeB);
//        RadioButton gTichuLostB = (RadioButton)findViewById(R.id.gTichuLostB);

        tempA = 0;
        tempB = 0;

        scoreA.setText("");
        scoreB.setText("");

        RadioGroup teamARadioGroup = (RadioGroup)findViewById(R.id.teamARadioGroup);
        RadioGroup teamBRadioGroup = (RadioGroup)findViewById(R.id.teamBRadioGroup);
//
        teamARadioGroup.clearCheck();
        teamBRadioGroup.clearCheck();

        oneTwoA.setChecked(false);
        oneTwoB.setChecked(false);
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

    public void changeTeamANameButton(View view) {
        /*Change the visibility of the components to be right*/

        TextView _teamATextView = (TextView) findViewById(R.id.TextViewTeamA);
        _teamATextView.setVisibility(View.INVISIBLE);

        EditText _teamAEditText = (EditText) findViewById(R.id.editTextTeamA);
        _teamAEditText.setVisibility(View.VISIBLE);

        ImageButton _resetNameButton = (ImageButton) findViewById(R.id.resetNamesButton);
        _resetNameButton.setVisibility(View.INVISIBLE);

        ImageButton _saveNamesButton = (ImageButton) findViewById(R.id.saveNameButton);
        _saveNamesButton.setVisibility(View.VISIBLE);
    }

    public void changeTeamBNameButton(View view) {

        TextView _teamBTextView = (TextView) findViewById(R.id.TextViewTeamB);
        _teamBTextView.setVisibility(View.INVISIBLE);

        EditText _teamBEditText = (EditText) findViewById(R.id.editTextTeamB);
        _teamBEditText.setVisibility(View.VISIBLE);

        ImageButton _resetNameButton = (ImageButton) findViewById(R.id.resetNamesButton);
        _resetNameButton.setVisibility(View.INVISIBLE);

        ImageButton _saveNamesButton = (ImageButton) findViewById(R.id.saveNameButton);
        _saveNamesButton.setVisibility(View.VISIBLE);
    }

    public void saveNamesButtonClick(View view) {
        //init the xml components
        TextView _teamATextView = (TextView) findViewById(R.id.TextViewTeamA);
        //set the visibility to be visible
        _teamATextView.setVisibility(View.VISIBLE);

        EditText _teamAEditText = (EditText) findViewById(R.id.editTextTeamA);
        _teamAEditText.setVisibility(View.INVISIBLE);

        TextView _teamBTextView = (TextView) findViewById(R.id.TextViewTeamB);
        _teamBTextView.setVisibility(View.VISIBLE);

        EditText _teamBEditText = (EditText) findViewById(R.id.editTextTeamB);
        _teamBEditText.setVisibility(View.INVISIBLE);

        //Change the TeamATextView text with whatever the teamAEditText contains
        //_teamATextView.setText(_teamAEditText.getText());
        //_teamBTextView.setText(_teamBEditText.getText());

        if (_teamAEditText.getText().toString().isEmpty()) {
            _teamATextView.setText("Team A");
        } else
            _teamATextView.setText(_teamAEditText.getText());

        if (_teamBEditText.getText().toString().isEmpty()) {
            _teamBTextView.setText("Team B");
        } else {
            _teamBTextView.setText(_teamBEditText.getText());
        }

        //And then make the buttons invisible and visible
        ImageButton _resetNameButton = (ImageButton) findViewById(R.id.resetNamesButton);
        _resetNameButton.setVisibility(View.VISIBLE);

        ImageButton _saveNamesButton = (ImageButton) findViewById(R.id.saveNameButton);
        _saveNamesButton.setVisibility(View.INVISIBLE);
    }

    public void resetNamesButton(View view) {

        TextView _teamATextView = (TextView) findViewById(R.id.TextViewTeamA);
        TextView _teamBTextView = (TextView) findViewById(R.id.TextViewTeamB);

        _teamATextView.setText("Team A");
        _teamBTextView.setText("Team B");
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
