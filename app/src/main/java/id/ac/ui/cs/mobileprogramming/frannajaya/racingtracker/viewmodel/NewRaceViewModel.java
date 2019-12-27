package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RaceRepository;

public class NewRaceViewModel extends AndroidViewModel {
    private RaceRepository raceRepo;
    private MutableLiveData<Boolean> createNewClicked = new MutableLiveData<>();

    public MutableLiveData<String> raceTitle = new MutableLiveData<>();
    public MutableLiveData<String> raceDescription = new MutableLiveData<>();

    public NewRaceViewModel(Application application) {
        super(application);
        raceRepo = new RaceRepository(application);
    }

    public String getRaceTitle() { return raceTitle.getValue(); }
    public void onRaceTitleChange(CharSequence s, int start, int before, int count) {
        raceTitle.setValue(s.toString());
    }

    public String getRaceDescription() { return raceDescription.getValue(); }
    public void onRaceDescriptionChange(CharSequence s, int start, int before, int count) {
        raceDescription.setValue(s.toString());
    }

    public MutableLiveData<Boolean> isCreateNewClicked() { return createNewClicked; }
    public void onCreateNewClicked() { createNewClicked.setValue(true); }
    public void resetCreateNewClicked() { createNewClicked.setValue(false); }

    public boolean validInput() {
        if (getRaceTitle() == null){
            return false;
        }
        if (getRaceDescription() == null){
            return false;
        }
        return true;
    }

    public long saveInstance() {
        long retVal = raceRepo.saveInstance(getRaceTitle(), getRaceDescription());
        return retVal;
    }
}