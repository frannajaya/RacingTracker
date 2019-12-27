package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.MatchRepository;

public class NewMatchViewModel extends AndroidViewModel {
    private RaceEntry thisRace;
    private MatchRepository matchRepository;
    private MutableLiveData<Boolean> createNewClicked = new MutableLiveData<>();

    public MutableLiveData<String> matchTitle = new MutableLiveData<>();
    public MutableLiveData<String> matchDescription = new MutableLiveData<>();

    public NewMatchViewModel(Application application) {
        super(application);
        matchRepository = new MatchRepository(application);
    }

    public void setThisRace(RaceEntry thisRace) { this.thisRace = thisRace; }

    public String getMatchTitle() { return matchTitle.getValue(); }
    public void onMatchTitleChange(CharSequence text, int start, int before, int count) {
        matchTitle.setValue(text.toString());
    }

    public String getMatchDescription() { return matchDescription.getValue(); }
    public void onMatchDescriptionChange(CharSequence text, int start, int before, int count) {
        matchDescription.setValue(text.toString());
    }

    public MutableLiveData<Boolean> isCreateNewClicked() { return createNewClicked; }
    public void onCreateNewClicked() { createNewClicked.setValue(true); }
    public void resetCreateNewClicked() { createNewClicked.setValue(false); }

    public boolean validInput() {
        if (getMatchTitle() == null){
            return false;
        }
        if (getMatchDescription() == null){
            return false;
        }
        return true;
    }

    public long saveInstance() {
        long retVal = matchRepository.saveInstance(thisRace.getId(), getMatchTitle(), getMatchDescription());
        return retVal;
    }
}