package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.display;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter.RaceAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter.MatchAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter.RecordAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;

import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

public class DataDisplay extends Fragment {

    private DataDisplayViewModel viewModel;

    @Inject
    DataDisplayViewModelFactory viewModelFactory;

    private RaceAdapter rcAdapter;
    private MatchAdapter mchAdapter;
    private RecordAdapter RcrdAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}