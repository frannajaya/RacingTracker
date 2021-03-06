package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.RaceitemBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.ViewHolder>  {

    private List<RaceEntry> raceList;
    private OnItemClickListener clickListener;

    public void setRaceList (List<RaceEntry> raceList) { this.raceList = raceList; }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RaceitemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.raceitem, parent, false
        );
        return new RaceAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RaceEntry raceItem = raceList.get(position);
        holder.bind(raceItem, this.clickListener);
    }

    @Override
    public int getItemCount() {
        return raceList.size();
    }

    // interface of the method used by this class
    public interface OnItemClickListener {
        void onItemClick(View view, RaceEntry raceItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RaceitemBinding binding;

        private ViewHolder(@NonNull RaceitemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final RaceEntry raceItem, final OnItemClickListener clickListener) {
            binding.setModel(raceItem);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null)
                        clickListener.onItemClick(view, raceItem);
                }
            });
        }
    }
}

