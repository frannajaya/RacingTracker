package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.MatchAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.MatchRepository;

public class RaceDetailsViewModel extends AndroidViewModel {
    private RaceEntry thisRace;
    private MatchRepository matchRepository;
    private MatchAdapter matchAdapter;

    private MutableLiveData<Boolean> addMatchClicked = new MutableLiveData<>();

    public RaceDetailsViewModel(@NonNull Application application) {
        super(application);
        matchRepository = new MatchRepository(application);
        matchAdapter = new MatchAdapter();
    }

    public void setThisRace(RaceEntry thisRace) { this.thisRace = thisRace; }

    public RaceEntry getThisRace() { return thisRace; }

    public void setAdapterClickListener(MatchAdapter.OnItemClickListener clickListener) {
        matchAdapter.setClickListener(clickListener);
    }

    public MatchAdapter getAdapter() { return matchAdapter; }

    public LiveData<List<MatchEntry>> getMatchRelatedToRace() { return matchRepository.getMatchRelatedToRace(thisRace.getId()); }

    public void setMatchListAdapter(List<MatchEntry> matches){
        matchAdapter.setRaceList(matches);
        matchAdapter.notifyDataSetChanged();
    }

    public void resetAddMatchClicked() { addMatchClicked.setValue(false); }
    public void onAddMatchClicked() { addMatchClicked.setValue(true); }
    public MutableLiveData<Boolean> isAddMatchClicked() { return addMatchClicked; }
}
