package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.NewmatchBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.NewMatchViewModel;

public class CreateNewMatchActivity extends AppCompatActivity {
    private NewMatchViewModel newMatchViewModel;
    private NewmatchBinding binding;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.newmatch);
        newMatchViewModel = ViewModelProviders.of(this).get(NewMatchViewModel.class);

        RaceEntry thisRace = getIntent().getParcelableExtra("raceItem");
        newMatchViewModel.setThisRace(thisRace);
        binding.setViewmodel(newMatchViewModel);
        binding.setRace(thisRace);
        observe();
    }

    public void observe(){
        newMatchViewModel.isCreateNewClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    newMatchViewModel.resetCreateNewClicked();
                    if(newMatchViewModel.validInput()){
                        long retVal = newMatchViewModel.saveInstance();
                        if (retVal == 1){
                            Intent resultIntent = new Intent();
                            // TODO Add extras or a data URI to this intent as appropriate.
                            resultIntent.putExtra("result", "Success Save " + newMatchViewModel.getMatchTitle() + " Match");
                            setResult(Activity.RESULT_OK, resultIntent);
                            finish();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "You have to fill all the field", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
