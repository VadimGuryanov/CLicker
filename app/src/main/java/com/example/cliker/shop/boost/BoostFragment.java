package com.example.cliker.shop.boost;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cliker.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BoostFragment extends Fragment implements BoostCallBack {

    public static BoostFragment newInstance() {
        BoostFragment fragment = new BoostFragment();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booster, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_forBooster);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new BoostAdapter(getBoosters(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<Booster> getBoosters() {
        ArrayList<Booster> boosters = new ArrayList<>();
        for (int i = 0; i < BoostData.CAPASITY; i++) {
            boosters.add(new Booster(BoostData.cloth_name[i], BoostData.description[i], BoostData.image[i], BoostData.point[i]));
        }
        return boosters;
    }


    @Override
    public void itemClick(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Покупка")
                .setMessage("Вы действительно хотите приобрести?")
                .setCancelable(false)
                .setPositiveButton("Да",
                        (dialog, id) -> Toast.makeText(getContext(), "Покупка совершена", Toast.LENGTH_SHORT).show())
                .setNegativeButton("Отмена",
                        (dialog, id) -> dialog.cancel());

        AlertDialog alert = builder.create();
        alert.show();
    }
}
