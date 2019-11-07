package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RaceTrackerDao{
    @Insert
    long insertRace(RaceEntry race);

    @Insert
    long insertMatch(MatchEntry match);

    @Insert
    long insertRecord(RecordEntry record);

    @Query("SELECT DISTINCT * FROM Race")
    LiveData<RaceEntry> getAllRaces();
}