package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;

import androidx.room.Room;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class MatchRepository {
    private String DbName = "db_match";
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize MatchRepository
    public MatchRepository(Context context) {
        RTDatabase = Room.databaseBuilder(context, RaceTrackerDatabase.class, DbName).build();
    }
}
