package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.MatchAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RecordAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RecordEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.MatchdetailsBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.RacedetailsBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.MatchDetailsViewModel;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.RaceDetailsViewModel;

public class MatchDetailsActivity extends AppCompatActivity implements RecordAdapter.OnItemClickListener {
    @Override
    public void onItemClick(View view, RecordEntry recordEntry) {
        Intent intent = new Intent(getApplicationContext(), RecordDetailsActivity.class);
        intent.putExtra("matchItem", recordEntry);
        startActivity(intent);
    }
    private MatchdetailsBinding binding;
    private MatchDetailsViewModel matchDetailsViewModel;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.matchdetails);
        matchDetailsViewModel = ViewModelProviders.of(this).get(MatchDetailsViewModel.class);

        RaceEntry thisRace = getIntent().getParcelableExtra("raceItem");
        raceDetailsViewModel.setThisRace(thisRace);

        raceDetailsViewModel.setAdapterClickListener(this);
        binding.setViewmodel(raceDetailsViewModel);
        binding.setRace(thisRace);
        binding.rvMatchList.setLayoutManager(new LinearLayoutManager(this));
        observe();
    }
    private void observe() {
        raceDetailsViewModel.getMatchRelatedToRace().observe(this, new Observer<List<MatchEntry>>() {
            @Override
            public void onChanged(List<MatchEntry> matches) {
                if(matches != null){
                    raceDetailsViewModel.setMatchListAdapter(matches);
                    binding.rvMatchList.setAdapter(raceDetailsViewModel.getAdapter());
                }
            }
        });
        raceDetailsViewModel.isAddMatchClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    raceDetailsViewModel.resetAddMatchClicked();
                    Intent intent = new Intent(getApplicationContext(), CreateNewMatchActivity.class);
                    intent.putExtra("raceItem", raceDetailsViewModel.getThisRace());
                    startActivityForResult(intent,0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
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