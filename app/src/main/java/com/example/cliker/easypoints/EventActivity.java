package com.example.cliker.easypoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cliker.BottomActivity;
import com.example.cliker.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    private int count = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        String name = getIntent().getStringExtra("name");
        int point = getIntent().getIntExtra("point", 0);
        TextView tv_name = findViewById(R.id.event_name_click);
        TextView tv_click = findViewById(R.id.point);
        TextView tv_point_click = findViewById(R.id.point_click);
        Button btn_goMain = findViewById(R.id.goToMain);
        tv_name.setText(name);
        tv_click.setText(" / " + point);
        int image = getIntent().getIntExtra("image", 0);
        ImageView iv_image = this.findViewById(R.id.event_image);
        iv_image.setImageResource(image);
        int i = getIntent().getIntExtra("index", 0);
        if (!EasyPointAdapter.events.get(i).isComplete()) {
            btn_goMain.setEnabled(false);
            tv_point_click.setText(0 + "");
        }
        else {
            tv_point_click.setText(point + "");
            iv_image.setEnabled(false);
        }
    }

    public void click(View view) {
        TextView tv_click = findViewById(R.id.point_click);
        int point = getIntent().getIntExtra("point", 0);
        if (count < point - 1) {
            count++;
            tv_click.setText(count + "");
        } else if (count == point - 1) {
            count++;
            tv_click.setText(count + "");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ты прошел событие!", Toast.LENGTH_SHORT);
            toast.show();
            Button btn_goMain = findViewById(R.id.goToMain);
            btn_goMain.setEnabled(true);
            view.setEnabled(false);
            int i = getIntent().getIntExtra("index", 0);
            EasyPointAdapter.events.get(i).setComplete(true);
        }
    }

    public void goMain(View view) {
        Intent intent = new Intent(this, BottomActivity.class);
        intent.putExtra("count", count);
        startActivity(intent);
    }
}
