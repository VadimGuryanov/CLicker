package com.example.cliker;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.cliker.money.MoneyProcessingAlgem;
import com.example.cliker.money.MoneyProcessingFizra;
import com.example.cliker.money.MoneyProcessingInfa;
import com.example.cliker.shop.ShopFragment;
import com.example.cliker.study.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;

import java.io.IOException;

public class BottomActivity extends AppCompatActivity {

    public static MoneyProcessingAlgem moneyProcessingAlgem;
    public static MoneyProcessingFizra moneyProcessingFizra;
    public static MoneyProcessingInfa moneyProcessingInfa;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    openFragment(ShopFragment.newInstance());
                    return true;

                case R.id.navigation_study:
                    openFragment(StudyFragment.newInstance());
                    return true;

                case R.id.navigation_home:
                    openFragment(MainFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
        try {
            moneyProcessingAlgem = new MoneyProcessingAlgem(this);
            moneyProcessingFizra = new MoneyProcessingFizra(this);
            moneyProcessingInfa = new MoneyProcessingInfa(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, fragment)
                .commit();
    }
}
