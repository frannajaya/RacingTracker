package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

    // Method handle go to Create race pressed.
    public void newRacePressed(View view) {
        Intent myIntent = new Intent(view.getContext(), CreateNewRaceActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
