package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.ChooselanguageBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.ChooseLanguageViewModel;

public class ChooseLanguageActivity extends AppCompatActivity {

    private ChooselanguageBinding binding;
    private ChooseLanguageViewModel chooseLanguageViewModel;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.home);
        chooseLanguageViewModel = ViewModelProviders.of(this).get(ChooseLanguageViewModel.class);

        binding.setViewModel(chooseLanguageViewModel);
        observe();
    }

    public void observe(){
        chooseLanguageViewModel.isEnSelected().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    chooseLanguageViewModel.resetEnSelected();
                    Resources res = getApplicationContext().getResources();
                    // Change locale settings in the app.
                    DisplayMetrics dm = res.getDisplayMetrics();
                    android.content.res.Configuration conf = res.getConfiguration();
                    conf.setLocale(new Locale("en")); // API 17+ only.
                    // Use conf.locale = new Locale(...) if targeting lower versions
                    res.updateConfiguration(conf, dm);
                    finish();
                }
            }
        });
        chooseLanguageViewModel.isInSelected().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    chooseLanguageViewModel.resetInSelected();
                    Resources res = getApplicationContext().getResources();
                    // Change locale settings in the app.
                    DisplayMetrics dm = res.getDisplayMetrics();
                    android.content.res.Configuration conf = res.getConfiguration();
                    conf.setLocale(new Locale("in")); // API 17+ only.
                    // Use conf.locale = new Locale(...) if targeting lower versions
                    res.updateConfiguration(conf, dm);
                    finish();
                }
            }
        });
    }
}