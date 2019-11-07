package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;

import androidx.room.Room;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class RaceRepository {
    private String DbName = "db_race";
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize MatchRepository
    public RaceRepository(Context context) {
        RTDatabase = Room.databaseBuilder(context, RaceTrackerDatabase.class, DbName).build();
    }
}
