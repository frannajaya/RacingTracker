package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RecordEntry;

public class RecordRepository {
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize MatchRepository
    public RecordRepository(Context context) {
        RTDatabase = RaceTrackerDatabase.getTrackerDatabase(context);
    }

    public LiveData<List<RecordEntry>> getRecordRelatedToMatch (int matchId) {
        return RTDatabase.raceTrackerDao().getAllRecordEntryRelated(matchId);
    }

    public long saveInstance(int matchId, String personName, String time, String imageLocation) {
        RecordEntry item = new RecordEntry(personName, time, imageLocation, matchId);
        new InsertRecordAsyncTask(RTDatabase).execute(item);
        return 1;
    }

    private class InsertRecordAsyncTask extends AsyncTask<RecordEntry, Void, Void> {
        private RaceTrackerDatabase RTDatabase;
        InsertRecordAsyncTask(RaceTrackerDatabase RTDatabase) {
            this.RTDatabase = RTDatabase;
        }
        @Override
        protected Void doInBackground(RecordEntry... records) {
            RTDatabase.raceTrackerDao().insertRecord(records[0]);
            return null;
        }
    }
}