package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.dpndncyinjction;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract void mainActivityInjector();
}
