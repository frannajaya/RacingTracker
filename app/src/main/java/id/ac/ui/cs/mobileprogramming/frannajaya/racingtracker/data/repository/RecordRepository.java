package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;

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
}