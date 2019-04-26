package com.example.cliker.study;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;
import com.example.cliker.clickers.AlgemClick;
import com.example.cliker.clickers.FizraClick;
import com.example.cliker.clickers.InfaClick;
import com.example.cliker.shop.ShopFragment;
import com.google.android.material.tabs.TabLayout;


public class StudyFragment extends Fragment {

    ViewPager pager;
    StudyAdapter pagerAdapter;

    public static StudyFragment newInstance() {
        StudyFragment fragment = new StudyFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        pager = view.findViewById(R.id.viewpager);
        pagerAdapter = new StudyAdapter(getChildFragmentManager());
        pagerAdapter.add(AlgemClick.newInstance());
        pagerAdapter.add(FizraClick.newInstance());
        pagerAdapter.add(InfaClick.newInstance());
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        return view;
    }
}
