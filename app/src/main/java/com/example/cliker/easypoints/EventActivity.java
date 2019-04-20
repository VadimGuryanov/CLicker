package com.example.cliker.easypoints;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cliker.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        String name = getIntent().getStringExtra("name");
        String point = getIntent().getStringExtra("point");
        String image = getIntent().getStringExtra("image");
        TextView tv_name = findViewById(R.id.event_name_click);
        ImageView iv_image = findViewById(R.id.event_image);
        TextView tv_click = findViewById(R.id.event_point);
        TextView tv_point = findViewById(R.id.point);
        tv_name.setText(name);
        iv_image.setImageResource(EventsData.image[Integer.parseInt(image)]);
        tv_point.setText(point);
    }
}
