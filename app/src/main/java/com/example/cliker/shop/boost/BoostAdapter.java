package com.example.cliker.shop.boost;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BoostAdapter extends RecyclerView.Adapter<BoosterHolder>{

    public static ArrayList<Booster> boosters;
    private BoostCallBack boostCallBack;

    public BoostAdapter(ArrayList<Booster> boosters, BoostCallBack boostCallBack) {
        this.boosters = boosters;
        this.boostCallBack = boostCallBack;
    }

    @NonNull
    @Override
    public BoosterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_elem_viewer, parent, false);
        return new BoosterHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BoosterHolder holder, int position) {
        holder.bind(boosters.get(position));
        holder.itemView.setOnClickListener(view -> boostCallBack.itemClick(position));
    }

    @Override
    public int getItemCount() {
        return BoostData.cloth_name.length;
    }
}
