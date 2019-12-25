package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ChooseLanguageViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> inSelected = new MutableLiveData<>();
    private MutableLiveData<Boolean> enSelected = new MutableLiveData<>();

    public ChooseLanguageViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> isInSelected() { return inSelected; }

    public MutableLiveData<Boolean> isEnSelected() { return enSelected; }

    public void onInSelected() { inSelected.setValue(true); }

    public void resetInSelected() { inSelected.setValue(false); }

    public void onEnSelected() { enSelected.setValue(true); }

    public void resetEnSelected() { enSelected.setValue(false); }
}
