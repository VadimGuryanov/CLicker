package com.example.cliker.easypoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cliker.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EasyPointFragment extends Fragment implements EasyPointCallBack {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_easy_points, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new EasyPointAdapter(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void itemClick(int i) {
        Intent intent = new Intent(this.getActivity(), EventActivity.class);
        intent.putExtra("name", EventsData.event_name[i]);
        intent.putExtra("image", i);
        intent.putExtra("point", EventsData.point[i]);
        startActivity(intent);
    }
}
