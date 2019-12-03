package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RaceRepository;

public class RaceViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> createNewClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> debtClicked = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();
    private RaceRepository raceRepo;

    public RaceViewModel(Application application) {
        super(application);
        repo = new Repository(application);
    }
}