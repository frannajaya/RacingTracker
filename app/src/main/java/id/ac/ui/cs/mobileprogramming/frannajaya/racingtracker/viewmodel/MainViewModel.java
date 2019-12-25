package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> newRaceClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> changeLanguageClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> savedRaceClicked = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> isNewRaceClicked() {
        return newRaceClicked;
    }

    public MutableLiveData<Boolean> isChangeLanguageClicked() {
        return changeLanguageClicked;
    }

    public MutableLiveData<Boolean> isSavedRaceClicked() { return savedRaceClicked; }

    public void onNewRaceClicked() {
        newRaceClicked.setValue(true);
    }

    public void resetNewRaceClicked() {
        newRaceClicked.setValue(false);
    }

    public void onChangeLanguageClicked() {
        changeLanguageClicked.setValue(true);
    }

    public void resetChangeLanguageClicked() {
        changeLanguageClicked.setValue(false);
    }

    public void onSavedRaceClicked() { savedRaceClicked.setValue(true); }

    public void resetSavedRaceClicked() { savedRaceClicked.setValue(false); }
}
