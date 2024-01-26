package com.example.viewpager2;

// TabFragment.java

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

    private static final String ARG_TAB_NUMBER = "tab_number";

    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment newInstance(int tabNumber) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_NUMBER, tabNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        TextView textView = view.findViewById(R.id.textView);
        if (getArguments() != null) {
            int tabNumber = getArguments().getInt(ARG_TAB_NUMBER);
            textView.setText("Content for Tab " + tabNumber);
        }
        return view;
    }
}

