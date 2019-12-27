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

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.NewraceBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.NewRaceViewModel;

public class CreateNewRaceActivity extends AppCompatActivity {
    private NewRaceViewModel viewModel;
    private NewraceBinding binding;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.newrace);
        viewModel = ViewModelProviders.of(this).get(NewRaceViewModel.class);

        binding.setViewModel(viewModel);
        observe();
    }

    public void observe(){
        viewModel.isCreateNewClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    viewModel.resetCreateNewClicked();
                    if(viewModel.validInput()){
                        long retVal = viewModel.saveInstance();
                        if (retVal == 1){
                            Intent resultIntent = new Intent();
                            // TODO Add extras or a data URI to this intent as appropriate.
                            resultIntent.putExtra("result", "Success Save " + viewModel.getRaceTitle() + " Race");
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
