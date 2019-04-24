package com.example.cliker.shop.tech;

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

public class TechFragment extends Fragment implements TechCallBack {


    public static TechFragment newInstance() {
        TechFragment techFragment = new TechFragment();
        return techFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tech, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_forShop);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new TechAdapter(this, getTech());
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public ArrayList<Devise> getTech(){
        ArrayList<Devise> devises = new ArrayList<>();
        for (int i = 0; i < TechData.CAPASITY; i++) {
            devises.add(new Devise(TechData.tech_name[i], TechData.description[i],
                    TechData.image[i], TechData.point[i]));
        }
        return devises;
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
