package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button newRaceButton = findViewById(R.id.new_race);

        newRaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "newRacePressed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button savedRaceButton = findViewById(R.id.saved_race);

        savedRaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "savedRacePressed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Method handle go to Create race pressed.
    public void newRacePressed(View view) {
        Intent myIntent = new Intent(view.getContext(), CreateNewRaceActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void savedRacePressed(View view) {
        Intent myIntent = new Intent(view.getContext(), RaceListActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
