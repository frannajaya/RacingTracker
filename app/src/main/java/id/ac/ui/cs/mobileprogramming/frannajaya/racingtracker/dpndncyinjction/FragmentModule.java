package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.dpndncyinjction;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.display.DataDisplay;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.insert.DataInsert;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    public abstract DataDisplay DataDisplay();

    @ContributesAndroidInjector
    public abstract DataInsert DataInsert();
}
