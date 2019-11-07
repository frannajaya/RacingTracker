package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;

public class RaceAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<RaceEntry> raceList = new ArrayList<RaceEntry>();

    public void RaceAdapter(Context context, List<RaceEntry> raceList){
        this.context = context;
        this.raceList = new ArrayList<RaceEntry>(raceList);
    }

    @Override
    public int getCount() {
        return raceList.size();
    }

    @Override
    public Object getItem(int i) {
        if (i > raceList.size()) {
            return "index data item is wrong";
        } else if (raceList.size() == 0){
            return "data is empty";
        } else {
            return raceList.get(i);
        }
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}