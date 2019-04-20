package com.example.cliker.shop.clothes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cliker.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;
    private TextView point;
    private ImageView image;

    public ClothHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name_cloth);
        this.point = itemView.findViewById(R.id.point_cloth);
        this.description = itemView.findViewById(R.id.description_cloth);
        this.image = itemView.findViewById(R.id.imageView_cloth);
    }

    public void bind(int i){
        this.name.setText(ClothData.cloth_name[i]);
        this.point.setText(String.valueOf(ClothData.point[i]));
        this.description.setText(ClothData.description[i]);
        this.image.setImageResource(ClothData.image[i]);
    }
}
