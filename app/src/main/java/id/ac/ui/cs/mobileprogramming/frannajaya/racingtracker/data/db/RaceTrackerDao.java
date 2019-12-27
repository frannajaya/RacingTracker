package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RaceTrackerDao{
    @Insert
    long insertRace(RaceEntry race);

    @Insert
    long insertMatch(MatchEntry match);

    @Insert
    long insertRecord(RecordEntry record);

    @Query("SELECT * FROM race_db")
    LiveData<List<RaceEntry>> getAllRaces();
    @Query("SELECT * FROM race_db where :raceId == race_db.id")
    RaceEntry getSpecifiedRace (int raceId);


    @Query("SELECT match_db.id, match_db.title, match_db.description, race_id FROM match_db JOIN race_db ON match_db.race_id == race_db.id where :raceIdGiven == match_db.race_id")
    LiveData<List<MatchEntry>> getAllMatchRelated(int raceIdGiven);
    @Query("SELECT * FROM match_db where :matchId == match_db.id")
    LiveData<MatchEntry> getSpecifiedMatch (int matchId);


    @Query("SELECT record_db.id, person_name, time_recorded, match_id FROM record_db JOIN match_db ON record_db.match_id == match_db.id where :matchIdGiven == record_db.match_id")
    LiveData<List<RecordEntry>> getAllRecordEntryRelated(int matchIdGiven);
    @Query("SELECT * FROM record_db where :recordId == record_db.id")
    LiveData<RecordEntry> getSpecifiedRecord (int recordId);
}