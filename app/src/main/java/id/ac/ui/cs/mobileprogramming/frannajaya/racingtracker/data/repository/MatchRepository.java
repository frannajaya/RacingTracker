package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class MatchRepository {
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize MatchRepository
    public MatchRepository(Context context) {
        this.RTDatabase = RaceTrackerDatabase.getTrackerDatabase(context);
    }

    public LiveData<List<MatchEntry>> getMatchRelatedToRace(int race_id){
        return RTDatabase.raceTrackerDao().getAllMatchRelated(race_id);
    }

    public long saveInstance(int raceId, String title, String description){
        MatchEntry newMatch = new MatchEntry(raceId, title, description);
        new MatchRepository.InsertMatchAsyncTask(RTDatabase).execute(newMatch);
        return 1;
    }

    private class InsertMatchAsyncTask extends AsyncTask<MatchEntry, Void, Void> {
        private RaceTrackerDatabase RTDatabase;
        InsertMatchAsyncTask(RaceTrackerDatabase RTDatabase) {
            this.RTDatabase = RTDatabase;
        }
        @Override
        protected Void doInBackground(MatchEntry... matches) {
            RTDatabase.raceTrackerDao().insertMatch(matches[0]);
            return null;
        }
    }
}
