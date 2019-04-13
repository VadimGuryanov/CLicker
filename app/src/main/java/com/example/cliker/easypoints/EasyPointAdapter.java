package com.example.cliker.easypoints;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EasyPointAdapter extends RecyclerView.Adapter<EventHolder> {

    private ArrayList<Event> events;
    private EasyPointCallBack callBack;

    public EasyPointAdapter(ArrayList<Event> events, EasyPointCallBack callBack) {
        this.events = events;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.event, viewGroup, false);
        return new EventHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder eventHolder, int position) {
        eventHolder.bind(events.get(position));
        eventHolder.itemView.setOnClickListener(view -> callBack.itemClick());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
