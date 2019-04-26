package com.example.cliker.shop.clothes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cliker.BottomActivity;
import com.example.cliker.MainFragment;
import com.example.cliker.R;

import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.cliker.BottomActivity.moneyProcessingAlgemBalance;
import static com.example.cliker.BottomActivity.moneyProcessingFizraBalance;
import static com.example.cliker.BottomActivity.moneyProcessingInfaBalance;

public class ClothesFragment extends Fragment implements ClothesCallBack, View.OnClickListener {


    public static ArrayList<Cloth> clothes;

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
    public void itemClick(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!ClothesAdapter.clothes.get(i).isSold()) {
            builder.setTitle("Покупка")
                    .setMessage("Вы действительно хотите приобрести?")
                    .setCancelable(false)
                    .setPositiveButton("Да",
                            (dialog, id) -> {
                                if (Integer.parseInt(moneyProcessingFizraBalance.getText()) >= ClothesAdapter.clothes.get(i).getPoint()) {
                                    Toast.makeText(getContext(), "Покупка совершена", Toast.LENGTH_SHORT).show();
                                    ClothesAdapter.clothes.get(i).setSold(true);

                                    ClothData.clothesProcessing.saveText(recording());
                                    int current = Integer.parseInt(moneyProcessingFizraBalance.getText()) - ClothesAdapter.clothes.get(i).getPoint();
                                    String s = Integer.toString(current);
                                    moneyProcessingFizraBalance.saveText(s);
                                }
                                else {
                                    Toast.makeText(getContext(), "У вас недостаточно кликов по физре", Toast.LENGTH_SHORT).show();
                                }
                            })
                    .setNegativeButton("Отмена",
                            (dialog, id) -> dialog.cancel());

            AlertDialog alert = builder.create();
            alert.show();
        }
        else {
            Toast.makeText(getContext(), "Эта футболочка уже куплена", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Cloth> getClothes(){
        if (clothes == null) {
            clothes = new ArrayList<>();
            for (int i = 0; i < ClothData.CAPASITY; i++) {
                clothes.add(new Cloth(ClothData.cloth_name[i], ClothData.description[i],
                        ClothData.image[i], ClothData.point[i], ClothData.image_boy[i],
                        ClothData.getIsSold()[i]));
            }
        }
        return clothes;
    }

    private String recording() {
        String bools = "";
        for (int i = 0; i < ClothesAdapter.clothes.size(); i++) {
            bools += String.valueOf(ClothesAdapter.clothes.get(i).isSold() + " ");
        }
        return bools;
    }

    @Override
    public void onClick(View v) {
    }
}
