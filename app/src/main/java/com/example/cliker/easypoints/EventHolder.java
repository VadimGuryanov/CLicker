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

    public void bind(int i) {
        this.name.setText(EventsData.event_name[i]);
        this.point.setText(String.valueOf("Кликни " + EventsData.point[i] + " раз и пройди событие!"));
        this.description.setText(EventsData.description[i]);
        this.image.setImageResource(EventsData.image[i]);
    }


}
