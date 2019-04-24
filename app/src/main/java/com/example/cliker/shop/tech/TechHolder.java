package com.example.cliker.shop.tech;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cliker.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TechHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;
    private TextView point;
    private ImageView image;

    public TechHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name_cloth);
        this.point = itemView.findViewById(R.id.point_cloth);
        this.description = itemView.findViewById(R.id.description_cloth);
        this.image = itemView.findViewById(R.id.imageView_cloth);
    }

    public void bind(Devise devise){
        this.name.setText(devise.getName());
        this.point.setText(devise.getPoint() + "");
        this.description.setText(devise.getDescription());
        this.image.setImageResource(devise.getImage());
    }


}
