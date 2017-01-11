package com.newbiedev.panos.tichucounter;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initiate FragmentManager. It's responsible for fragment initiation.
    FragmentManager fragmentManager = getFragmentManager();
    private int counterA, counterB;
    List<Integer> scoreTeamA = new ArrayList<Integer>();
    List<Integer> scoreTeamB = new ArrayList<Integer>();
    ArrayAdapter<Integer> adapterA, adapterB;
    private int tempA = 0, tempB = 0;

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

        adapterA = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, scoreTeamA);
        adapterB = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, scoreTeamB);

        scoreListA.setAdapter(adapterA);
        scoreListB.setAdapter(adapterB);

        deseselectCheckBoxes();
    }

    private void reInitGame() {


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

    public void deseselectCheckBoxes() {
        final CheckBox tichuMadeA = (CheckBox) findViewById(R.id.tichuMadeA);
        final CheckBox tichuMadeB = (CheckBox) findViewById(R.id.tichuMadeB);
        final CheckBox gTichuMadeA = (CheckBox) findViewById(R.id.gTichuMadeA);
        final CheckBox gTichuMadeB = (CheckBox) findViewById(R.id.gTichuMadeB);
        final CheckBox tichuLostA = (CheckBox) findViewById(R.id.tichuLostA);
        final CheckBox gTichuLostA = (CheckBox) findViewById(R.id.gTichuLostA);
        final CheckBox tichuLostB = (CheckBox) findViewById(R.id.tichuLostB);
        final CheckBox gTichuLostB = (CheckBox) findViewById(R.id.gTichuLostB);
        final CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
        final CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);


        tichuMadeA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeB.setChecked(false);
                tichuLostA.setChecked(false);
                gTichuMadeA.setChecked(false);
                gTichuLostA.setChecked(false);
                gTichuMadeB.setChecked(false);
                oneTwoB.setChecked(false);
            }
        });
        tichuMadeB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeA.setChecked(false);
                tichuLostB.setChecked(false);
                gTichuMadeB.setChecked(false);
                gTichuLostB.setChecked(false);
                oneTwoA.setChecked(false);
            }
        });
        tichuLostA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeA.setChecked(false);
                gTichuMadeA.setChecked(false);
                gTichuLostA.setChecked(false);
            }
        });
        gTichuMadeA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gTichuMadeB.setChecked(false);
                tichuMadeB.setChecked(false);
                tichuLostA.setChecked(false);
                tichuMadeA.setChecked(false);
                gTichuLostA.setChecked(false);
                oneTwoB.setChecked(false);
            }
        });
        gTichuLostA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeA.setChecked(false);
                gTichuMadeA.setChecked(false);
                tichuLostA.setChecked(false);
            }
        });
        tichuLostB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeB.setChecked(false);
                gTichuMadeB.setChecked(false);
                gTichuLostB.setChecked(false);
            }
        });
        gTichuMadeB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gTichuMadeA.setChecked(false);
                tichuMadeA.setChecked(false);
                tichuLostB.setChecked(false);
                gTichuLostB.setChecked(false);
                tichuMadeB.setChecked(false);
                oneTwoA.setChecked(false);
            }
        });
        gTichuLostB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeB.setChecked(false);
                gTichuMadeB.setChecked(false);
                tichuLostB.setChecked(false);
            }
        });
        oneTwoA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeB.setChecked(false);
                gTichuMadeB.setChecked(false);
                oneTwoB.setChecked(false);
            }
        });
        oneTwoB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tichuMadeA.setChecked(false);
                gTichuMadeA.setChecked(false);
                oneTwoA.setChecked(false);
            }
        });
    }

    public void playButtonClick(View view) {

        EditText scoreA = (EditText) findViewById(R.id.scoreAEditText);
        EditText scoreB = (EditText) findViewById(R.id.scoreBEditText);

        CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
        CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);

        CheckBox tichuMadeA = (CheckBox) findViewById(R.id.tichuMadeA);
        CheckBox tichuLostA = (CheckBox) findViewById(R.id.tichuLostA);
        CheckBox gTichuMadeA = (CheckBox) findViewById(R.id.gTichuMadeA);
        CheckBox gTichuLostA = (CheckBox) findViewById(R.id.gTichuLostA);

        CheckBox tichuMadeB = (CheckBox) findViewById(R.id.tichuMadeB);
        CheckBox tichuLostB = (CheckBox) findViewById(R.id.tichuLostB);
        CheckBox gTichuMadeB = (CheckBox) findViewById(R.id.gTichuMadeB);
        CheckBox gTichuLostB = (CheckBox) findViewById(R.id.gTichuLostB);

        RadioButton smallGame = (RadioButton) findViewById(R.id.smallGame);
        RadioButton normalGame = (RadioButton) findViewById(R.id.normalGame);

        final TextView totalScoreA = (TextView) findViewById(R.id.totalScoreA);
        final TextView totalScoreB = (TextView) findViewById(R.id.totalScoreB);
        TextView nameTeamA = (TextView) findViewById(R.id.TextViewTeamA);
        TextView nameTeamB = (TextView) findViewById(R.id.TextViewTeamB);

        if (scoreA.getText().toString().isEmpty() && scoreB.getText().toString().isEmpty()) {
            if (oneTwoA.isChecked() && !oneTwoB.isChecked()) {
                tempA = 200;
                if (tichuMadeA.isChecked()) {
                    tempA += 100;
                    if (tichuLostB.isChecked())
                        tempB = -100;
                    else if (gTichuLostB.isChecked())
                        tempB = -200;
                } else if (tichuLostA.isChecked())
                    tempA -= 100;
                else if (gTichuMadeA.isChecked()) {
                    tempA += 200;
                    if (tichuLostB.isChecked())
                        tempB = -100;
                    else if (gTichuLostB.isChecked())
                        tempB = -200;
                } else if (gTichuLostA.isChecked())
                    tempA -= 200;
                scoreTeamA.add(0, tempA);
                scoreTeamB.add(0, tempB);
            } else if (!oneTwoA.isChecked() && oneTwoB.isChecked()) {
                tempB = 200;
                if (tichuMadeB.isChecked()) {
                    tempB += 100;
                    if (tichuLostA.isChecked())
                        tempA = -100;
                    else if (gTichuLostA.isChecked())
                        tempA = -200;
                } else if (tichuLostB.isChecked())
                    tempB -= 100;
                else if (gTichuMadeB.isChecked()) {
                    tempB += 200;
                    if (tichuLostA.isChecked())
                        tempA = -100;
                    else if (gTichuLostA.isChecked())
                        tempA = -200;
                } else if (gTichuLostB.isChecked())
                    tempB -= 200;
                scoreTeamA.add(0, tempA);
                scoreTeamB.add(0, tempB);
            }
        } else if (scoreB.getText().toString().isEmpty() || scoreB.getText().equals("")) {
            int sA = Integer.parseInt(scoreA.getText().toString());
            if (sA % 5 == 0 && sA <= 125 && sA >= -25) {
                tempA = sA;
                tempB = 100 - tempA;
                if (tichuMadeA.isChecked()) {
                    tempA += 100;
                    if (tichuLostB.isChecked())
                        tempB -= 100;
                    else if (gTichuLostB.isChecked())
                        tempB -= 200;
                } else if (tichuLostA.isChecked()) {
                    tempA -= 100;
                    if (tichuMadeB.isChecked())
                        tempB += 100;
                    else if (gTichuMadeB.isChecked())
                        tempB += 200;
                    else if (tichuLostB.isChecked())
                        tempB -= 100;
                    else if (gTichuLostB.isChecked())
                        tempB -= 200;
                } else if (gTichuMadeA.isChecked()) {
                    tempA += 200;
                    if (tichuLostB.isChecked())
                        tempB -= 100;
                    else if (gTichuLostB.isChecked())
                        tempB -= 200;
                } else if (gTichuLostA.isChecked()) {
                    tempA -= 200;
                    if (tichuMadeB.isChecked())
                        tempB += 100;
                    else if (gTichuMadeB.isChecked())
                        tempB += 200;
                    else if (tichuLostB.isChecked())
                        tempB -= 100;
                    else if (gTichuLostB.isChecked())
                        tempB -= 200;
                }
                scoreTeamA.add(0, tempA);
                scoreTeamB.add(0, tempB);
            }
        } else if (scoreA.getText().toString().isEmpty() || scoreA.getText().equals("")) {
            int sB = Integer.parseInt(scoreB.getText().toString());
            if (sB % 5 == 0 && sB <= 125 && sB >= -25) {
                tempB = sB;
                tempA = 100 - tempB;
                if (tichuMadeB.isChecked()) {
                    tempB += 100;
                    if (tichuLostA.isChecked())
                        tempA -= 100;
                    else if (gTichuLostA.isChecked())
                        tempA -= 200;
                } else if (tichuLostB.isChecked()) {
                    tempB -= 100;
                    if (tichuMadeA.isChecked())
                        tempA += 100;
                    else if (tichuLostA.isChecked())
                        tempA -= 100;
                    else if (gTichuMadeA.isChecked())
                        tempA += 200;
                    else if (gTichuLostA.isChecked())
                        tempA -= 200;
                } else if (gTichuMadeB.isChecked()) {
                    tempB += 200;
                    if (tichuLostA.isChecked())
                        tempA -= 100;
                    else if (gTichuLostA.isChecked())
                        tempA -= 200;
                } else if (gTichuLostB.isChecked()) {
                    tempB -= 200;
                    if (tichuMadeA.isChecked())
                        tempA += 100;
                    else if (tichuLostA.isChecked())
                        tempA -= 100;
                    else if (gTichuMadeA.isChecked())
                        tempA += 200;
                    else if (gTichuLostA.isChecked())
                        tempA -= 200;
                }

                scoreTeamA.add(0, tempA);
                scoreTeamB.add(0, tempB);
            }
        } else if (!scoreA.getText().toString().isEmpty() && !scoreB.getText().toString().isEmpty()) {
            int sA = Integer.parseInt(scoreA.getText().toString());
            int sB = Integer.parseInt(scoreB.getText().toString());
            if ((sA % 5 == 0 && sB % 5 == 0) && (sA >= -25 && sA <= 125) && (sB >= -25 && sB <= 125)) {
                if (sA == 100 - sB) {
                    tempA = sA;
                    tempB = sB;
                    if (tichuMadeB.isChecked()) {
                        tempB += 100;
                        if (tichuLostA.isChecked())
                            tempA -= 100;
                        else if (gTichuLostA.isChecked())
                            tempA -= 200;
                    } else if (tichuLostB.isChecked()) {
                        tempB -= 100;
                        if (tichuMadeA.isChecked())
                            tempA += 100;
                        else if (tichuLostA.isChecked())
                            tempA -= 100;
                        else if (gTichuMadeA.isChecked())
                            tempA += 200;
                        else if (gTichuLostA.isChecked())
                            tempA -= 200;
                    } else if (gTichuMadeB.isChecked()) {
                        tempB += 200;
                        if (tichuLostA.isChecked())
                            tempA -= 100;
                        else if (gTichuLostA.isChecked())
                            tempA -= 200;
                    } else if (gTichuLostB.isChecked()) {
                        tempB -= 200;
                        if (tichuMadeA.isChecked())
                            tempA += 100;
                        else if (tichuLostA.isChecked())
                            tempA -= 100;
                        else if (gTichuMadeA.isChecked())
                            tempA += 200;
                        else if (gTichuLostA.isChecked())
                            tempA -= 200;
                    }
                    scoreTeamA.add(0, tempA);
                    scoreTeamB.add(0, tempB);
                } else if (sB == 100 - sA) {
                    tempA = sA;
                    tempB = sB;
                    if (tichuMadeA.isChecked()) {
                        tempA += 100;
                        if (tichuLostB.isChecked())
                            tempB -= 100;
                        else if (gTichuLostB.isChecked())
                            tempB -= 200;
                    } else if (tichuLostA.isChecked()) {
                        tempA -= 100;
                        if (tichuMadeB.isChecked())
                            tempB += 100;
                        else if (gTichuMadeB.isChecked())
                            tempB += 200;
                        else if (tichuLostB.isChecked())
                            tempB -= 100;
                        else if (gTichuLostB.isChecked())
                            tempB -= 200;
                    } else if (gTichuMadeA.isChecked()) {
                        tempA += 200;
                        if (tichuLostB.isChecked())
                            tempB -= 100;
                        else if (gTichuLostB.isChecked())
                            tempB -= 200;
                    } else if (gTichuLostA.isChecked()) {
                        tempA -= 200;
                        if (tichuMadeB.isChecked())
                            tempB += 100;
                        else if (gTichuMadeB.isChecked())
                            tempB += 200;
                        else if (tichuLostB.isChecked())
                            tempB -= 100;
                        else if (gTichuLostB.isChecked())
                            tempB -= 200;
                    }
                    scoreTeamA.add(0, tempA);
                    scoreTeamB.add(0, tempB);
                }
            }
        }

        counterA += tempA;
        counterB += tempB;

        totalScoreA.setText(String.valueOf(counterA));
        totalScoreB.setText(String.valueOf(counterB));

        ClearFields();

        if (smallGame.isChecked()) {
            if (counterA >= 500 || counterB >= 500) {
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
                builder.setMessage("Win!");
                if (counterA >= 500) {
                    builder.setTitle(nameTeamA.getText().toString() + " are damn good!");
                    builder.setMessage(nameTeamB.getText().toString() + " are LOSERS!");
                } else if (counterB >= 500) {
                    builder.setTitle(nameTeamB.getText().toString() + " are damn good!");
                    builder.setMessage(nameTeamA.getText().toString() + " are LOSERS!");
                }
                builder.setButton(AlertDialog.BUTTON_POSITIVE, "New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newGamePreparation();
                        reInitGame();
                        dialog.dismiss();
                    }
                });
                builder.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        } else if (normalGame.isChecked()) {
            if (counterA >= 1000 || counterB >= 1000) {
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
                builder.setMessage("Win!");
                if (counterA >= 1000) {
                    builder.setTitle(nameTeamA.getText().toString() + " are damn good!");
                    builder.setMessage(nameTeamB.getText().toString() + " are LOSERS!");
                } else if (counterB >= 1000) {
                    builder.setTitle(nameTeamB.getText().toString() + " are damn good!");
                    builder.setMessage(nameTeamA.getText().toString() + " are LOSERS!");
                }
                builder.setButton(AlertDialog.BUTTON_POSITIVE, "New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newGamePreparation();
                        reInitGame();
                        dialog.dismiss();
                    }
                });
                builder.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        }

        adapterA.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();
    }

    private void ClearFields() {

        EditText scoreA = (EditText) findViewById(R.id.scoreAEditText);
        EditText scoreB = (EditText) findViewById(R.id.scoreBEditText);

        CheckBox oneTwoA = (CheckBox) findViewById(R.id.oneTwoA);
        CheckBox oneTwoB = (CheckBox) findViewById(R.id.oneTwoB);

        CheckBox tichuMadeA = (CheckBox) findViewById(R.id.tichuMadeA);
        CheckBox tichuLostA = (CheckBox) findViewById(R.id.tichuLostA);
        CheckBox gTichuMadeA = (CheckBox) findViewById(R.id.gTichuMadeA);
        CheckBox gTichuLostA = (CheckBox) findViewById(R.id.gTichuLostA);

        CheckBox tichuMadeB = (CheckBox) findViewById(R.id.tichuMadeB);
        CheckBox tichuLostB = (CheckBox) findViewById(R.id.tichuLostB);
        CheckBox gTichuMadeB = (CheckBox) findViewById(R.id.gTichuMadeB);
        CheckBox gTichuLostB = (CheckBox) findViewById(R.id.gTichuLostB);

        tempA = 0;
        tempB = 0;

        scoreA.setText("");
        scoreB.setText("");

        tichuMadeA.setChecked(false);
        tichuLostA.setChecked(false);
        gTichuMadeA.setChecked(false);
        gTichuLostA.setChecked(false);

        tichuMadeB.setChecked(false);
        tichuLostB.setChecked(false);
        gTichuMadeB.setChecked(false);
        gTichuLostB.setChecked(false);

        oneTwoA.setChecked(false);
        oneTwoB.setChecked(false);
    }

    public void newGameButtonClick(View view) {

        RadioButton smallGame = (RadioButton) findViewById(R.id.smallGame);
        RadioButton normalGame = (RadioButton) findViewById(R.id.normalGame);

        if (smallGame.isChecked() || normalGame.isChecked()) {


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

        AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
        builder.setTitle("Reset names");
        builder.setMessage("Are you sure you want to reset team names?");
        builder.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView _teamATextView = (TextView) findViewById(R.id.TextViewTeamA);
                TextView _teamBTextView = (TextView) findViewById(R.id.TextViewTeamB);

                _teamATextView.setText("Team A");
                _teamBTextView.setText("Team B");
                dialog.dismiss();
            }
        });
        builder.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void newGamePreparation() {
        TextView totalScoreA = (TextView) findViewById(R.id.totalScoreA);
        TextView totalScoreB = (TextView) findViewById(R.id.totalScoreB);

        ClearFields();
        scoreTeamA.clear();
        scoreTeamB.clear();
        totalScoreA.setText("");
        totalScoreB.setText("");
        counterA = 0;
        counterB = 0;
    }

    private void undoButtonClick() {
        TextView totalScoreA = (TextView) findViewById(R.id.totalScoreA);
        TextView totalScoreB = (TextView) findViewById(R.id.totalScoreB);

        if (scoreTeamA.isEmpty() || scoreTeamB.isEmpty()) {
            AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
            builder.setTitle("Undo Failed.");
            builder.setMessage("There is nothing to undo.");
            builder.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();
        } else if (scoreTeamA.size() == 1 || scoreTeamB.size() == 1) {
            counterA = 0;
            counterB = 0;
            scoreTeamA.clear();
            scoreTeamB.clear();

            totalScoreA.setText("");
            totalScoreB.setText("");
        } else {
            counterA -= scoreTeamA.get(scoreTeamA.size() - 1);
            counterB -= scoreTeamB.get(scoreTeamB.size() - 1);

            scoreTeamA.remove(scoreTeamA.size() - 1);
            scoreTeamB.remove(scoreTeamB.size() - 1);

            totalScoreA.setText(String.valueOf(counterA));
            totalScoreB.setText(String.valueOf(counterB));
        }

        adapterA.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();
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
                AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
                builder.setTitle("New Game?");
                builder.setMessage("Are you sure you want to start a new game?");
                builder.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reInitGame();
                        newGamePreparation();
                        dialog.dismiss();
                    }
                });
                builder.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
            case R.id.undoButton:
                //something
                undoButtonClick();
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
