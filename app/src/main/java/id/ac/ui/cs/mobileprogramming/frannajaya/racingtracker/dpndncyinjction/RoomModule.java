package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.dpndncyinjction;

import android.app.Application;
import androidx.room.Room;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDao;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;


@Module
class RoomModule {
    @Provides
    @Singleton
    RaceTrackerDatabase provideDatabase(Application theapplication){
        return Room.databaseBuilder(theapplication, RaceTrackerDatabase.class, "race_tracker.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */
    @Provides
    @Singleton
    RaceTrackerDao provideRaceTrackerDao(RaceTrackerDatabase appDatabase){
        return appDatabase.daoAccess();
    }
}