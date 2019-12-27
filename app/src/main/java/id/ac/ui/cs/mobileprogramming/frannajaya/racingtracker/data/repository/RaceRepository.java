package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class RaceRepository {
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize RaceRepository
    public RaceRepository(Context context) {
        this.RTDatabase = RaceTrackerDatabase.getTrackerDatabase(context);
    }

    public LiveData<List<RaceEntry>> getRaces(){
        return RTDatabase.raceTrackerDao().getAllRaces();
    }

    public RaceEntry getRaceById(int id) {
        GetSpecifiedRaceAsyncTask item = new GetSpecifiedRaceAsyncTask(RTDatabase);
        item.execute(id);
        return item.getRace();
    }

    public long saveInstance(String title, String description){
        RaceEntry newRace = new RaceEntry(title, description);
        new InsertRaceAsyncTask(RTDatabase).execute(newRace);
        return 1;
    }

    private class InsertRaceAsyncTask extends AsyncTask<RaceEntry, Void, Void> {
        private RaceTrackerDatabase RTDatabase;
        InsertRaceAsyncTask(RaceTrackerDatabase RTDatabase) {
            this.RTDatabase = RTDatabase;
        }
        @Override
        protected Void doInBackground(RaceEntry... races) {
            RTDatabase.raceTrackerDao().insertRace(races[0]);
            return null;
        }
    }

    private class GetSpecifiedRaceAsyncTask extends AsyncTask<Integer, Void, Void> {
        private RaceEntry race;
        private RaceTrackerDatabase RTDatabase;
        GetSpecifiedRaceAsyncTask(RaceTrackerDatabase RTDatabase) {
            this.RTDatabase = RTDatabase;
        }
        @Override
        protected Void doInBackground(Integer... integers) {
            race = RTDatabase.raceTrackerDao().getSpecifiedRace(integers[0]);
            return null;
        }
        public RaceEntry getRace(){return race;}
    }
}
