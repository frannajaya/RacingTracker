package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.R;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RecordEntry;
import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.databinding.RecorditemBinding;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder>  {

    private List<RecordEntry> recordList;
    private OnItemClickListener clickListener;

    public void setRecordList (List<RecordEntry> recordList) { this.recordList = recordList; }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecorditemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.recorditem, parent, false
        );
        return new RecordAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecordEntry recordEntry = recordList.get(position);
        holder.bind(recordEntry, this.clickListener);
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    // interface of the method used by this class
    public interface OnItemClickListener {
        void onItemClick(View view, RecordEntry recordItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RecorditemBinding binding;

        private ViewHolder(@NonNull RecorditemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final RecordEntry recordItem, final OnItemClickListener clickListener) {
            binding.setModel(recordItem);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null)
                        clickListener.onItemClick(view, recordItem);
                }
            });
        }
    }
}

