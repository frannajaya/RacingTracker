package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.dpndncyinjction;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.display.DataDisplayViewModel;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.insert.DataInsertViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DataDisplayViewModel.class)
    abstract ViewModel bindDataDisplayViewModel(DataDisplayViewModel viewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(DataInsertViewModel.class)
//    abstract ViewModel bindTopRatedViewModel(DataInsertViewModel viewModel);

}