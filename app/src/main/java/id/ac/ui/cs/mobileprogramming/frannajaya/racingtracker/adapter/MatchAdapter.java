package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.MatchEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.MatchitemBinding;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder>  {

    private List<MatchEntry> matchList;
    private OnItemClickListener clickListener;

    public void setRaceList (List<MatchEntry> matchList) { this.matchList = matchList; }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MatchitemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.matchitem, parent, false
        );
        return new MatchAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchEntry matchEntry = matchList.get(position);
        holder.bind(matchEntry, this.clickListener);
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    // interface of the method used by this class
    public interface OnItemClickListener {
        void onItemClick(View view, MatchEntry raceItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private MatchitemBinding binding;

        private ViewHolder(@NonNull MatchitemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final MatchEntry matchItem, final OnItemClickListener clickListener) {
            binding.setModel(matchItem);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null)
                        clickListener.onItemClick(view, matchItem);
                }
            });
        }
    }
}

