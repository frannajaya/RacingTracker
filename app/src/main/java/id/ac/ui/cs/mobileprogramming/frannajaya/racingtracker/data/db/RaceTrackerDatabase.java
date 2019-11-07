package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {RaceEntry.class, MatchEntry.class, RecordEntry.class},
        version = 1,
        exportSchema = false
)
public abstract class RaceTrackerDatabase extends RoomDatabase {
    public abstract RaceTrackerDao daoAccess();
}
