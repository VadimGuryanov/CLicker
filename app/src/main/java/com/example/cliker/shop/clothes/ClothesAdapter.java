package com.example.cliker.shop.clothes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothesAdapter extends RecyclerView.Adapter<ClothHolder> {

    private ClothesCallBack clothesCallBack;
    public static ArrayList<Cloth> clothes;

    public ClothesAdapter(ArrayList<Cloth> clothes, ClothesCallBack clothesCallBack) {
        this.clothesCallBack = clothesCallBack;
        this.clothes = clothes;
    }

    @NonNull
    @Override
    public ClothHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shop_elem_viewer, viewGroup, false);
        return new ClothHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothHolder holder, int position) {
        holder.bind(clothes.get(position));
        holder.itemView.setOnClickListener(view -> clothesCallBack.itemClick(position));
    }

    @Override
    public int getItemCount() {
        return ClothData.cloth_name.length;
    }
}
