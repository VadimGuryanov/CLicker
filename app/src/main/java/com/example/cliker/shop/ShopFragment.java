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
import com.example.cliker.shop.clothes.ClothesFragment;
import com.example.cliker.study.StudyFragment;

import static com.example.cliker.R.id.btn_clothes;

public class ShopFragment extends Fragment implements View.OnClickListener{

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
        return rootview;


    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.container_main, fragment)
                .commit();

    }

    @Override
    public void onClick(View v) {
        openFragment(ClothesFragment.newInstance());
    }
}
