package com.example.cliker.easypoints;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cliker.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;
    private TextView point;
    private ImageView image;

    public EventHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.tv_name);
        this.point = itemView.findViewById(R.id.tv_point);
        this.description = itemView.findViewById(R.id.tv_description);
        this.image = itemView.findViewById(R.id.image_event);
    }

    public void bind(Event event) {
        this.name.setText(event.getName());
        this.point.setText(String.valueOf("Кликни " + event.getPoint() + " раз и пройди событие!"));
        this.description.setText(event.getDescription());
        this.image.setImageResource(event.getImage());
    }


}
