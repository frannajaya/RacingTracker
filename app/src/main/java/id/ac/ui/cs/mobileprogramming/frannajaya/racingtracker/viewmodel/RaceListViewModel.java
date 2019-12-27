package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RaceAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RaceRepository;

public class RaceListViewModel extends AndroidViewModel {
    private RaceRepository raceRepository;
    private RaceAdapter raceAdapter;

    public RaceListViewModel(@NonNull Application application) {
        super(application);
        raceRepository = new RaceRepository(application);
        raceAdapter = new RaceAdapter();
    }

    public LiveData<List<RaceEntry>> getRaces() { return raceRepository.getRaces(); }

    public void setAdapterClickListener(RaceAdapter.OnItemClickListener clickListener) {
        raceAdapter.setClickListener(clickListener);
    }

    public RaceAdapter getAdapter() { return raceAdapter; }

    public void setRaceListAdapter(List<RaceEntry> races){
        raceAdapter.setRaceList(races);
        raceAdapter.notifyDataSetChanged();
    }
}
