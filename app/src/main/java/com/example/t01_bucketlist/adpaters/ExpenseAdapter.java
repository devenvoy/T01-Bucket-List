package com.example.t01_bucketlist.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t01_bucketlist.R;
import com.example.t01_bucketlist.model.ExpenseItem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ExpenseAdapter extends FirebaseRecyclerAdapter<ExpenseItem, ExpenseAdapter.ExpenseViewHolder> {

    public ExpenseAdapter(@NonNull FirebaseRecyclerOptions<ExpenseItem> options) {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull ExpenseViewHolder holder,
                     int position, @NonNull ExpenseItem model) {
    }

    @NonNull
    @Override
    public ExpenseViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bucket_card_item, parent, false);
        return new ExpenseAdapter.ExpenseViewHolder(view);
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}