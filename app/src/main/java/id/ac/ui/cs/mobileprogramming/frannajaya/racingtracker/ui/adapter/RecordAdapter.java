package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RecordEntry;

public class RecordAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<RecordEntry> recordList = new ArrayList<RecordEntry>();

    public void RecordAdapter(Context context, List<RecordEntry> recordList){
        this.context = context;
        this.recordList = new ArrayList<RecordEntry>(recordList);
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