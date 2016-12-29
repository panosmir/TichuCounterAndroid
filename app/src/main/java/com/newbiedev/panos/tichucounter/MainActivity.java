package com.newbiedev.panos.tichucounter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView finalScoreTextView;
    private RadioGroup scoreRadioGroup;
    private Button playButton, roundButton;
    Fragment _playFragment = new Fragment();
    //Fragment _mainFragment = new Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PlayFragment playFragment = (PlayFragment)fragmentManager.findFragmentById(R.id.play_fragment_container);

        fragmentTransaction.hide(playFragment);
        fragmentTransaction.commit();
        //playButton = (Button) findViewById(R.id.playButton);
        roundButton = (Button)findViewById(R.id.roundButton);

    }

    public void newGameButtonClick(View view){
        playButton = (Button) findViewById(R.id.playButton);
        finalScoreTextView = (TextView)findViewById(R.id.finalScoreTextView);
        scoreRadioGroup = (RadioGroup)findViewById(R.id.scoreRadioGroup);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PlayFragment playFragment = (PlayFragment)fragmentManager.findFragmentById(R.id.play_fragment_container);

        fragmentTransaction.add(R.id.play_fragment_container, _playFragment, "PLAY_FRAGMENT");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.show(playFragment);
        fragmentTransaction.commit();

        playButton.setVisibility(View.INVISIBLE);
        roundButton.setVisibility(View.VISIBLE);
        finalScoreTextView.setVisibility(View.INVISIBLE);
        scoreRadioGroup.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
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
