package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RaceAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.SavedraceBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.RaceListViewModel;

public class RaceListActivity extends AppCompatActivity implements RaceAdapter.OnItemClickListener {
    @Override
    public void onItemClick(View view, RaceEntry raceItem) {
        Intent intent = new Intent(getApplicationContext(), RaceDetailsActivity.class);
        intent.putExtra("raceItem", raceItem);
        startActivity(intent);
    }
    private SavedraceBinding binding;
    private RaceListViewModel raceListViewModel;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.savedrace);
        raceListViewModel = ViewModelProviders.of(this).get(RaceListViewModel.class);

        raceListViewModel.setAdapterClickListener(this);
        binding.setViewmodel(raceListViewModel);
        binding.rvRaceList.setLayoutManager(new LinearLayoutManager(this));
        observe();
    }
    private void observe() {
        raceListViewModel.getRaces().observe(this, new Observer<List<RaceEntry>>() {
            @Override
            public void onChanged(List<RaceEntry> races) {
                raceListViewModel.setRaceListAdapter(races);
                binding.rvRaceList.setAdapter(raceListViewModel.getAdapter());
            }
        });
    }
}