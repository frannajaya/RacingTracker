package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;

public class MatchAdapter extends BaseAdapter{
    private Context context = null;
    private ArrayList<MatchEntry> matchList = new ArrayList<MatchEntry>();

    public void MatchAdapter(Context context, List<MatchEntry> matchList){
        this.context = context;
        this.matchList = new ArrayList<MatchEntry>(matchList);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
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