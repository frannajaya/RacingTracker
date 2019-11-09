package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.viewmodel;

import androidx.lifecycle.ViewModel;

public class RaceViewModel extends ViewModel {

    public ObservableArrayList<String> raceItem;

    public void onClickedItem(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
            cells.put(stringFromNumbers(row, column), game.currentPlayer.value);
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }
}
//adapter = new ArrayAdapter<String>(this,
//        android.R.layout.simple_list_item_1,
//        listFruits);
//        setListAdapter(adapter);

