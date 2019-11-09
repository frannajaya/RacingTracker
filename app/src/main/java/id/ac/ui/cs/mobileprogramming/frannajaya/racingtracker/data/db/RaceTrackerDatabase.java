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
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    RaceTrackerDatabase.class, "race-tracker-database")
                    .allowMainThreadQueries()
                    .build();
            // allow queries on the main thread.
            // Don't do this on a real app! See PersistenceBasicSample for an example.
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}