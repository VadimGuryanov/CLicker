package com.example.cliker.shop.clothes;

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

public class ClothesFragment extends Fragment implements ClothesCallBack, View.OnClickListener {

    public static ClothesFragment newInstance() {
        ClothesFragment fragment = new ClothesFragment();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_forShop);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new ClothesAdapter(getClothes(), this);
        recyclerView.setAdapter(adapter);
        return view;
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

    public ArrayList<Cloth> getClothes(){
        ArrayList<Cloth> clothes = new ArrayList<>();
        for (int i = 0; i < ClothData.CAPASITY; i++) {
            clothes.add(new Cloth(ClothData.cloth_name[i], ClothData.description[i],
                    ClothData.image[i], ClothData.point[i]));
        }
        return clothes;
    }

    @Override
    public void onClick(View v) {
    }
}
