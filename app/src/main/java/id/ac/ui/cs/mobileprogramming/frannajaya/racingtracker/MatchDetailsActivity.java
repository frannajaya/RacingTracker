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

        MatchEntry thisMatch = getIntent().getParcelableExtra("matchItem");
        matchDetailsViewModel.setThisMatch(thisMatch);

        matchDetailsViewModel.setAdapterClickListener(this);
        binding.setViewmodel(matchDetailsViewModel);
        binding.setMatch(thisMatch);
        binding.setRace(matchDetailsViewModel.getThisRace());
        binding.rvRecordList.setLayoutManager(new LinearLayoutManager(this));
        observe();
    }
    private void observe() {
        matchDetailsViewModel.getRecordRelatedToMatch().observe(this, new Observer<List<RecordEntry>>() {
            @Override
            public void onChanged(List<RecordEntry> records) {
                if(records != null){
                    matchDetailsViewModel.setRecordListAdapter(records);
                    binding.rvRecordList.setAdapter(matchDetailsViewModel.getAdapter());
                }
            }
        });
        matchDetailsViewModel.isAddRecordClicked().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    matchDetailsViewModel.resetAddRecordClicked();
                    Intent intent = new Intent(getApplicationContext(), CreateNewRecordActivity.class);
                    intent.putExtra("matchItem", matchDetailsViewModel.getThisMatch());
                    intent.putExtra("raceItem", matchDetailsViewModel.getThisRace());
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