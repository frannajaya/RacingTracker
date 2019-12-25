package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RaceAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RaceRepository;

public class NewRaceViewModel extends AndroidViewModel {
    private RaceRepository raceRepo;
    private RaceAdapter adapter = new RaceAdapter();

    private MutableLiveData<Boolean> createNewClicked = new MutableLiveData<>();

    public NewRaceViewModel(Application application) {
        super(application);
        raceRepo = new RaceRepository(application);
        adapter.setRaceList(new ArrayList<RaceEntry>());
    }

}