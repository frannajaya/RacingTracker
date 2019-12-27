package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import android.app.Application;
import android.net.Uri;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository.RecordRepository;

public class NewRecordViewModel extends AndroidViewModel {
    private RaceEntry thisRace;
    private MatchEntry thisMatch;
    private RecordRepository recordRepository;

    private int status = 0;

    private String imageLocation;
    private boolean canTakePicture = false;

    private MutableLiveData<Boolean> takePictureClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> startClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean> createNewClicked = new MutableLiveData<>();

    public MutableLiveData<String> personName = new MutableLiveData<>();
    public MutableLiveData<String> recordTime = new MutableLiveData<>();

    public String getMatchTitle() { return thisMatch.getTitle(); }

    public NewRecordViewModel(Application application) {
        super(application);
        recordRepository = new RecordRepository(application);
    }
    public void onStartClicked() { startClicked.setValue(true); }
    public MutableLiveData<Boolean> isStartClicked() { return startClicked; }
    public void resetStartClicked() { startClicked.setValue(false); }

    public MutableLiveData<Boolean> isCreateNewClicked() { return createNewClicked; }
    public void onCreateNewClicked() { createNewClicked.setValue(true); }
    public void resetCreateNewClicked() { createNewClicked.setValue(false); }

    public MutableLiveData<Boolean> isTakePictureClicked() { return takePictureClicked; }
    public void onTakePictureClicked() { takePictureClicked.setValue(true); }
    public void resetTakePictureClicked() { takePictureClicked.setValue(false); }

    public void canNotTakePicture() { canTakePicture = false;}
    public void canTakePicture() { canTakePicture = true; }

    public void setThisRace(RaceEntry thisRace) { this.thisRace = thisRace; }
    public void setThisMatch(MatchEntry thisMatch) { this.thisMatch = thisMatch; }

    public void setRecordTime(String recordedtime) { this.recordTime.setValue(recordedtime); }
    public String getRecordTime() { return this.recordTime.getValue(); }
    public String getPersonName() { return personName.getValue(); }

    public void onPersonNameChange(CharSequence text, int start, int before, int count) {
        personName.setValue(text.toString());
    }

    public boolean validInput() {
        if (getPersonName() == null) {
            return false;
        }
        return true;
    }

    public String getImageLocation() { return this.imageLocation; }
    public boolean getCamPermission() { return canTakePicture; }

    public long saveInstance() {
        long retVal = recordRepository.saveInstance(thisMatch.getId(), getPersonName(), getRecordTime(), getImageLocation());
        return retVal;
    }

    public void statusChange(){
        if (status == 0){
            status = 1;
        }
        else if (status == 1){
            status = 2;
        }
        else {
            status = 2;
        }
    }
    public int getStatus(){return this.status;}
    public void setImageURI(String uri){ this.imageLocation = uri; }
}