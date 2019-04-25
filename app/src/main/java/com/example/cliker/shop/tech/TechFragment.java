package com.example.cliker.shop.tech;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;
import com.example.cliker.clickers.InfaClick;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.cliker.BottomActivity.moneyProcessingAlgem;
import static com.example.cliker.BottomActivity.moneyProcessingInfaBalance;

public class TechFragment extends Fragment implements TechCallBack {


    public static ArrayList<Devise> devises;


    public static TechFragment newInstance() {
        TechFragment techFragment = new TechFragment();
        return techFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tech, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_forTech);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new TechAdapter(this, getTech());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<Devise> getTech(){
        if (devises == null) {
            devises = new ArrayList<>();
            for (int i = 0; i < TechData.CAPASITY; i++) {
                devises.add(new Devise(TechData.tech_name[i], TechData.description[i],
                        TechData.image[i], TechData.point[i], TechData.boosts[i]));
            }
        }
        return devises;
    }

    @Override
    public void itemClick(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!TechAdapter.devises.get(i).isSold()) {
            builder.setTitle("Покупка")
                    .setMessage("Вы действительно хотите приобрести?")
                    .setCancelable(false)
                    .setPositiveButton("Да",
                            (dialog, id) -> {
                                if (Integer.parseInt(moneyProcessingInfaBalance.getText()) >= TechAdapter.devises.get(i).getPoint()) {
                                    Toast.makeText(getContext(), "Покупка совершена", Toast.LENGTH_SHORT).show();
                                    TechAdapter.devises.get(i).setSold(true);
                                    InfaClick.number += TechAdapter.devises.get(i).getBoost();
                                    int current = Integer.parseInt(moneyProcessingInfaBalance.getText()) - TechAdapter.devises.get(i).getPoint();
                                    String s = Integer.toString(current);
                                    moneyProcessingInfaBalance.saveText(s);
                                }
                                else {
                                    Toast.makeText(getContext(), "У вас недостаточно кликов по инфе", Toast.LENGTH_SHORT).show();
                                }
                            })
                    .setNegativeButton("Отмена",
                            (dialog, id) -> dialog.cancel());

            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            Toast.makeText(getContext(), "Этот копьюктер куплен", Toast.LENGTH_SHORT).show();
        }
    }
}
