package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.content.Context;
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
                        int retVal = viewModel.saveInstance();
                        if (retVal == 1){
                            Context context = getApplicationContext();
                            CharSequence text = "Success Save " + viewModel.getTitle() + " Race";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                        finish();
                    }
                    else{
                        Context context = getApplicationContext();
                        CharSequence text = "You Have to fill all the field needed";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }
        });
    }
}
