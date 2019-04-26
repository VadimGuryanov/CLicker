package com.example.cliker.easypoints;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EasyPointFragment extends Fragment implements EasyPointCallBack {

    public static ArrayList<Event> a;

    public static EasyPointFragment newInstance() {
        EasyPointFragment fragment = new EasyPointFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_easy_points, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new EasyPointAdapter(getMyList(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<Event> getMyList() {
        if (a == null) {
            a = new ArrayList<>();
            for (int i = 0; i < EventsData.CAPACITY; i++) {
                a.add(new Event(EventsData.event_name[i], EventsData.description[i], EventsData.point[i],
                        EventsData.image[i], EventsData.getIsSold()[i]));
            }
        }
        return a;
    }

    @Override
    public void itemClick(Event event, int i) {
        Intent intent = new Intent(this.getActivity(), EventActivity.class);
        intent.putExtra("name", event.getName());
        intent.putExtra("point", event.getPoint());
        intent.putExtra("image", event.getImage());
        intent.putExtra("index", i);
        startActivity(intent);
    }


}
