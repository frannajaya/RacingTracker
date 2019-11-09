package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDao;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class CreateNewRaceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrace);
        Button saveTheRace = findViewById(R.id.save_race);
        saveTheRace.setOnClickListener(new saveBtnListener());
    }
    class saveBtnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String titleRace = ((EditText) findViewById(R.id.race_name_input)).getText().toString();
            if (titleRace.length() == 0){
                Snackbar.make(view, "Please fill race title", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return;
            }
            String descriptionRace = ((EditText) findViewById(R.id.race_name_input)).getText().toString();
            if (descriptionRace.length() == 0){
                Snackbar.make(view, "Please fill the description", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return;
            }
            RaceEntry newRace = new RaceEntry(titleRace, descriptionRace);

            RaceTrackerDao thedao = RaceTrackerDatabase.getTrackerDatabase(getApplicationContext()).raceTrackerDao();

            thedao.insertRace(newRace);

            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);
        }
    }
}
