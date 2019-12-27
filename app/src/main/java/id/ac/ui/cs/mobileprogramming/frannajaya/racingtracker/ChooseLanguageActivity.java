package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
        binding = DataBindingUtil.setContentView(this, R.layout.chooselanguage);
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
                    preferences.edit().putString("language", "en").apply();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result", "Success change language to English");
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
        chooseLanguageViewModel.isInSelected().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    chooseLanguageViewModel.resetInSelected();
                    preferences.edit().putString("language", "in").apply();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result", "Berhasil mengganti bahasa menjadi bahasa Indonesia");
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}