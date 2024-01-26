package com.example.viewpager2;

// SectionsPagerAdapter.java

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 2) {  // Cambiar a 1 si estás contando desde 0
            return new GalleryFragment();
        } else {
            return TabFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

