package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {RaceEntry.class, MatchEntry.class, RecordEntry.class},
        version = 1,
        exportSchema = false
)
public abstract class RaceTrackerDatabase extends RoomDatabase {

    private static RaceTrackerDatabase INSTANCE;

    public abstract RaceTrackerDao raceTrackerDao();

    public static RaceTrackerDatabase getTrackerDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (RaceTrackerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RaceTrackerDatabase.class, "race_tracker_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}