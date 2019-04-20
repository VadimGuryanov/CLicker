package com.example.cliker.shop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cliker.R;
import com.example.cliker.shop.boost.BoostFragment;
import com.example.cliker.shop.clothes.ClothesFragment;
import com.example.cliker.study.StudyFragment;

import static com.example.cliker.R.id.btn_clothes;
import static com.example.cliker.R.id.center;

public class ShopFragment extends Fragment implements View.OnClickListener {

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_shop, container, false);

        Button clothes = rootview.findViewById(btn_clothes);
        Button tech = rootview.findViewById(R.id.btn_tech);
        Button boost = rootview.findViewById(R.id.btn_boost);
        clothes.setOnClickListener(this);
        boost.setOnClickListener(this);
        tech.setOnClickListener(this);
        return rootview;


    }

    private void openFragment(int index, Fragment fragment1, Fragment fragment2, Fragment fragment3) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (index) {
            case 1:
                fragmentTransaction
                        .replace(R.id.container_main, fragment1)
                        .commit();
                break;
            case 2:
                fragmentTransaction
                        .replace(R.id.container_main, fragment2)
                        .commit();
                break;
            case 3:
                fragmentTransaction
                        .replace(R.id.container_main, fragment3)
                        .commit();
        }
    }

    public int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.btn_clothes:
                index = 1;
                break;
            case R.id.btn_tech:
                index = 2;
                break;
            case R.id.btn_boost:
                index = 3;
                break;
        }
        return index;
    }

    @Override
    public void onClick(View v) {
        int index = translateIdToIndex(v.getId());
        openFragment(index, ClothesFragment.newInstance(), ClothesFragment.newInstance(), BoostFragment.newInstance());
    }
}
