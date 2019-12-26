package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter.RaceAdapter;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.RacedetailsBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.NewRaceViewModel;

public class RaceListActivity extends AppCompatActivity implements RaceAdapter.OnItemClickListener {
    @Override
    public void onItemClick(View view, RaceEntry raceItem) {

    }
//    private RacedetailsBinding binding;
//    private NewRaceViewModel newRaceViewModel;
//    private SharedPreferences preferences;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);
//        binding = DataBindingUtil.setContentView(this, R.layout.racedetails);
//        newRaceViewModel = ViewModelProviders.of(this).get(NewRaceViewModel.class);
//        newRaceViewModel.setAdapterClickListener(this);
//        newRaceViewModel.email.setValue(preferences.getString("email", ""));
//
//        binding.setViewModel(viewModel);
//        binding.rvDebtList.setLayoutManager(new LinearLayoutManager(this));
//        binding.rvDebtList.setAdapter(viewModel.getAdapter());
//
//        binding.ivBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//
//        observe();
//        ActivityGameBinding raceListBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
//        newRaceViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
//        gameViewModel.init(player1, player2);
//        activityGameBinding.setGameViewModel(gameViewModel);
//        setUpOnGameEndListener();
//
//    }
//
//    @Override
//    public void onItemClick(View view, RaceEntry raceItem) {
//        Intent intent = new Intent(getApplicationContext(), RaceDetailsActivity.class);
//        intent.putExtra("race", raceItem);
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//

}