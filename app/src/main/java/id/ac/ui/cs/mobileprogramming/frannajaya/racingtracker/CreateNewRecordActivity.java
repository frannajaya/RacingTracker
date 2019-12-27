package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.NewrecordBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.NewRecordViewModel;

public class CreateNewRecordActivity extends AppCompatActivity {

    private NewRecordViewModel newRecordViewModel;
    private NewrecordBinding binding;
    private SharedPreferences preferences;
    private Uri file;
    private Handler handler = new Handler();
    public long timeCount = 0;
    public boolean runtimer = false;

    public void timer(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = (int)(timeCount/3600);
                int minutes = (int)((timeCount%60));
                int secs = (int)(timeCount%(3600));

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                newRecordViewModel.setRecordTime(time);

                if(runtimer){
                    timeCount++;
                }

                handler.postDelayed(this, 100);
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.newmatch);
        newRecordViewModel = ViewModelProviders.of(this).get(NewRecordViewModel.class);

        RaceEntry thisRace = getIntent().getParcelableExtra("raceItem");
        MatchEntry thisMatch = getIntent().getParcelableExtra("matchItem");
        newRecordViewModel.setThisRace(thisRace);
        newRecordViewModel.setThisMatch(thisMatch);
        binding.setViewmodel(newRecordViewModel);
        binding.setRace(thisRace);
        binding.setMatch(thisMatch);
        observe(this);
    }
    public void observe(final Context context){
        newRecordViewModel.isTakePictureClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    newRecordViewModel.resetTakePictureClicked();
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        newRecordViewModel.canNotTakePicture();
                        ActivityCompat.requestPermissions((Activity) context, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
                    }
                    if (newRecordViewModel.getCamPermission()){
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        file = Uri.fromFile(getOutputMediaFile());
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

                        startActivityForResult(intent, 100);
                    }
                }
            }
        });
        newRecordViewModel.isStartClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    newRecordViewModel.resetStartClicked();
                    newRecordViewModel.statusChange();
                    if (newRecordViewModel.getStatus() == 1){
                        runtimer = true;
                        timer();
                    }
                    Button playButton = (Button) findViewById(R.id.startBtn);
                    playButton.setVisibility(View.GONE);
                    Button stopButton = (Button) findViewById(R.id.finishBtn);
                    stopButton.setVisibility(View.VISIBLE);
                }
            }
        });
        newRecordViewModel.isCreateNewClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    newRecordViewModel.resetCreateNewClicked();
                    if(newRecordViewModel.validInput()){
                        long retVal = newRecordViewModel.saveInstance();
                        if (retVal == 1){
                            Intent resultIntent = new Intent();
                            // TODO Add extras or a data URI to this intent as appropriate.
                            resultIntent.putExtra("result", "Success Save " +
                                    newRecordViewModel.getPersonName() + " for Match " +
                                    newRecordViewModel.getMatchTitle());
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                newRecordViewModel.canTakePicture();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                newRecordViewModel.setImageURI("");
            }
        }
    }

    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "racingtracker");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }
}
