package com.example.t01_bucketlist;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class homeAdapter extends FragmentPagerAdapter {


    public homeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new onboard1();
        }
        else if (position==1){
            return new onboard2();
        }
        else if (position==2){
            return new onboard3();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
