package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;

import androidx.room.Room;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class RaceRepository {
    private String DbName = "db_race";
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize RaceRepository
    public RaceRepository(Context context) {
        RTDatabase = Room.databaseBuilder(context, RaceTrackerDatabase.class, DbName).build();
    }

    public int saveInstance(String title, String description){
        RaceEntry newRace = new RaceEntry(title, description);
        RTDatabase.raceTrackerDao().insertRace(newRace);
        return 1;
    }
}
