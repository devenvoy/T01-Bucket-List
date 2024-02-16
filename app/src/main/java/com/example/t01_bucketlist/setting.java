package com.example.t01_bucketlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class setting extends Fragment {

    FirebaseAuth mAuth;
    private FirebaseUser currentuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting, container, false);
        mAuth = FirebaseAuth.getInstance();
        currentuser = mAuth.getCurrentUser();
        // Inflate the layout for this fragment
        return view;
    }

    public void logout(View view) {
        mAuth.signOut();
        getActivity().finish();
    }
}