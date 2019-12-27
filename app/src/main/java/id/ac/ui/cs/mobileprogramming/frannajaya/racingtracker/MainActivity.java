package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.MainViewModel;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.HomeBinding;

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
                    startActivityForResult(new Intent(getApplicationContext(),CreateNewRaceActivity.class),0);
                }
            }
        });
        mainViewModel.isChooseLanguageClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    mainViewModel.resetChooseLanguageClicked();
                    startActivityForResult(new Intent(getApplicationContext(),ChooseLanguageActivity.class),1);
                    checkLanguage();
                }
            }
        });
        mainViewModel.isSavedRaceClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    mainViewModel.resetSavedRaceClicked();
                    startActivityForResult(new Intent(getApplicationContext(), RaceListActivity.class),2);
                }
            }
        });
    }
    public void checkLanguage(){
        Resources res = getApplicationContext().getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if (conf.locale.toString().equalsIgnoreCase(preferences.getString("language", "en"))){
            return;
        }
        String language = preferences.getString("language","en");
        conf.setLocale(new Locale(language)); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);
    }

    @Override
    public void onBackPressed() {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            default : {
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(getApplicationContext(), data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
