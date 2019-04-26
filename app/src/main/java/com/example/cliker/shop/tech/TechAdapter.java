package com.example.cliker.shop.tech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TechAdapter extends RecyclerView.Adapter<TechHolder> {

    private TechCallBack techCallBack;
    public static ArrayList<Devise> devises;

    public TechAdapter(TechCallBack techCallBack, ArrayList<Devise> devises) {
        this.techCallBack = techCallBack;
        this.devises = devises;
    }

    @NonNull
    @Override
    public TechHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shop_elem_viewer, viewGroup, false);
        return new TechHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TechHolder holder, int position) {
        holder.bind(devises.get(position));
        holder.itemView.setOnClickListener(view -> techCallBack.itemClick(position));
    }

    @Override
    public int getItemCount() {
        return TechData.tech_name.length;
    }
}
