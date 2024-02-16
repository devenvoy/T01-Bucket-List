package com.example.t01_bucketlist.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.t01_bucketlist.R;
import com.example.t01_bucketlist.model.BucketItem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ExpenseAdapter extends FirebaseRecyclerAdapter<BucketItem, ExpenseAdapter.ExpenseViewHolder> {

    public ExpenseAdapter(@NonNull FirebaseRecyclerOptions<BucketItem> options) {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull ExpenseViewHolder holder,
                     int position, @NonNull BucketItem model) {

        holder.tName.setText(model.getName());
        holder.tDate.setText(model.getDate());
        holder.tcat.setText(model.getCategory());

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
        ImageView cardImg;
        TextView tName, tDate, tcat;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImg = itemView.findViewById(R.id.card_image);
            tName = itemView.findViewById(R.id.card_name);
            tcat = itemView.findViewById(R.id.card_cate);
            tDate = itemView.findViewById(R.id.card_date);
        }
    }


}