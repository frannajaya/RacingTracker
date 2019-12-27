package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RecordAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RecordEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RaceRepository;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RecordRepository;

public class MatchDetailsViewModel extends AndroidViewModel {
    private MatchEntry thisMatch;
    private RaceEntry thisRace;
    private RaceRepository raceRepository;
    private RecordRepository recordRepository;
    private RecordAdapter recordAdapter;

    private MutableLiveData<Boolean> addRecordClicked = new MutableLiveData<>();

    public MatchDetailsViewModel(@NonNull Application application) {
        super(application);
        recordRepository = new RecordRepository(application);
        raceRepository = new RaceRepository(application);
        recordAdapter = new RecordAdapter();
    }

    public void setThisMatch(MatchEntry thisMatch) {
        this.thisMatch = thisMatch;
        thisRace = raceRepository.getRaceById(thisMatch.getRaceId());
    }

    public RaceEntry getThisRace() { return thisRace; }
    public MatchEntry getThisMatch() { return thisMatch; }

    public void setAdapterClickListener(RecordAdapter.OnItemClickListener clickListener) {
        recordAdapter.setClickListener(clickListener);
    }

    public RecordAdapter getAdapter() { return recordAdapter; }

    public LiveData<List<RecordEntry>> getRecordRelatedToMatch() { return recordRepository.getRecordRelatedToMatch(thisMatch.getId()); }

    public void setRecordListAdapter(List<RecordEntry> records){
        recordAdapter.setRecordList(records);
        recordAdapter.notifyDataSetChanged();
    }

    public void resetAddRecordClicked() { addRecordClicked.setValue(false); }
    public void onAddRecordClicked() { addRecordClicked.setValue(true); }
    public MutableLiveData<Boolean> isAddRecordClicked() { return addRecordClicked; }
}
