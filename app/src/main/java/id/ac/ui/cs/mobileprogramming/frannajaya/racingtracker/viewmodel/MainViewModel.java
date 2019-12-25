package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> newRaceClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> chooseLanguageClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> savedRaceClicked = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> isNewRaceClicked() {
        return newRaceClicked;
    }

    public MutableLiveData<Boolean> isChooseLanguageClicked() {
        return chooseLanguageClicked;
    }

    public MutableLiveData<Boolean> isSavedRaceClicked() { return savedRaceClicked; }

    public void onNewRaceClicked() {
        newRaceClicked.setValue(true);
    }

    public void resetNewRaceClicked() {
        newRaceClicked.setValue(false);
    }

    public void onChooseLanguageClicked() {
        chooseLanguageClicked.setValue(true);
    }

    public void resetChooseLanguageClicked() {
        chooseLanguageClicked.setValue(false);
    }

    public void onSavedRaceClicked() { savedRaceClicked.setValue(true); }

    public void resetSavedRaceClicked() { savedRaceClicked.setValue(false); }
}
