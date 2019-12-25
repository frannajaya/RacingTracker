package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.SavedraceBinding;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceEntry;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.ViewHolder>  {

    private List<RaceEntry> raceList;
    private OnItemClickListener clickListener;

    public void setRaceList (List<RaceEntry> raceList) {
        this.raceList = raceList;
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SavedraceBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.savedrace, parent, false
        );
        return new RaceAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RaceEntry raceListed = raceList.get(position);
        holder.bind(raceListed, this.clickListener);
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
        private SavedraceBinding binding;

        private ViewHolder(@NonNull SavedraceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final RaceEntry raceItem, final OnItemClickListener clickListener) {
            binding.setRaceModel(raceItem);
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

