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

    @Query("SELECT DISTINCT * FROM Racedb")
    LiveData<RaceEntry> getAllRaces();

    @Query("SELECT * FROM Matchdb JOIN Racedb ON Matchdb.race_id == Racedb.id where :raceIdGiven == Matchdb.race_id")
    LiveData<MatchEntry> getAllMatchRelated(int raceIdGiven);

    @Query("SELECT * FROM Recorddb JOIN Matchdb ON Recorddb.match_id == Matchdb.id where :matchIdGiven == Recorddb.match_id")
    LiveData<RecordEntry> getAllRecordEntryRelated(int matchIdGiven);

    @Query("SELECT * FROM Recorddb where :recordId == Recorddb.id")
    LiveData<RecordEntry> getSpecifiedRecord (int recordId);
}