package com.example.cliker.easypoints;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView description;
    private TextView point;

    public EventHolder(@NonNull View itemView) {
        super(itemView);
        this.name = name;
        this.point = point;
        this.description = description;
    }

    public TextView getName() {
        return name;
    }
    public TextView getPoint() {
        return point;
    }

    public TextView getDescription() {
        return description;
    }

    public void bind(Event event) {
        this.name.setText(event.getName());
        this.point.setText(event.getPoint());
        this.description.setText(event.getDescription());
    }
}
