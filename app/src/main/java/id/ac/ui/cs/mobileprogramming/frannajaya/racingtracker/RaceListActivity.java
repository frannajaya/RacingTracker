package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker;

import android.app.Activity;
import android.os.Bundle;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel.RaceViewModel;

public class RaceListActivity extends Activity {

    private RaceViewModel raceViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedrace);

        ActivityGameBinding raceListBinding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        raceViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.init(player1, player2);
        activityGameBinding.setGameViewModel(gameViewModel);
        setUpOnGameEndListener();

    }

}