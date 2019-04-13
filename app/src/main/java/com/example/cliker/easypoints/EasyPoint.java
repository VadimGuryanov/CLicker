package com.example.cliker.easypoints;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cliker.R;

import java.util.ArrayList;

public class EasyPoint extends AppCompatActivity implements EasyPointCallBack{

    private RecyclerView rv_easypoint;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_points);
        rv_easypoint = findViewById(R.id.RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new EasyPointAdapter(getList(), this);
        rv_easypoint.setLayoutManager(layoutManager);
        rv_easypoint.setAdapter(adapter);

    }


    public ArrayList<Event> getList() {
        events = new ArrayList<>();
        events.add(
                new Event("Мероппреятие",
                        "Мероприятие...",
                        10)
        );
        events.add(new Event("Сходить куда-то", "Сходить куда-то", 5));
        events.add(new Event("Посмотреть что-то", "Посмотреть что-то",  3));
        return events;
    }


    @Override
    public void itemClick() {

    }
}
