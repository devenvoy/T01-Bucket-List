package com.example.t01_bucketlist;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t01_bucketlist.adpaters.ExpenseAdapter;
import com.example.t01_bucketlist.model.ExpenseItem;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class home_frag extends Fragment {

    private View view;
    RecyclerView recyclerView;
    ExpenseAdapter adapter;
    FloatingActionButton fabAdd;
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_frag, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        fabAdd = view.findViewById(R.id.fab_add);
        database = FirebaseDatabase.getInstance();

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Expense")
                .limitToLast(50);

        FirebaseRecyclerOptions<ExpenseItem> options = new FirebaseRecyclerOptions.Builder<ExpenseItem>()
                .setQuery(query, ExpenseItem.class)
                .build();

        adapter = new ExpenseAdapter(options);

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.stopListening();
    }
}