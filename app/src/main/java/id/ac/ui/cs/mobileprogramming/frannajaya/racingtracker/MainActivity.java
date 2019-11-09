package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button newRaceButton = findViewById(R.id.new_race_button);
        newRaceButton.setOnClickListener(new nrButtonListener());

        Button savedRaceButton = findViewById(R.id.saved_race_button);
        savedRaceButton.setOnClickListener(new srButtonListener());
    }
    class nrButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), CreateNewRaceActivity.class);
            startActivityForResult(myIntent, 0);
        }
    }

    class srButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), RaceListActivity.class);
            startActivityForResult(myIntent, 0);
        }
    }
}
