package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.HomeBinding;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private HomeBinding binding;
    private MainViewModel mainViewModel;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.home);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setViewmodel(mainViewModel);
        observe();
    }

    public void observe(){
        mainViewModel.isNewRaceClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    mainViewModel.resetNewRaceClicked();
                    startActivity(new Intent(getApplicationContext(), CreateNewRaceActivity.class));
                }
            }
        });
        mainViewModel.isChangeLanguageClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    mainViewModel.resetChangeLanguageClicked();
                    startActivity(new Intent(getApplicationContext(), ChangeLanguageActivity.class));
                }
            }
        });
        mainViewModel.isSavedRaceClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    mainViewModel.resetSavedRaceClicked();
                    startActivity(new Intent(getApplicationContext(), RaceListActivity.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }
}
