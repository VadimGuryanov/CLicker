package com.example.cliker.shop.clothes;

import android.os.Bundle;

import com.example.cliker.MainFragment;
import com.example.cliker.R;
import com.example.cliker.shop.ShopFragment;
import com.example.cliker.shop.boost.BoostFragment;
import com.example.cliker.study.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ShopActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_shop:
                openFragment(ClothesFragment.newInstance());
                return true;
            case R.id.navigation_home:
                openFragment(BoostFragment.newInstance());
                return true;
            case R.id.navigation_study:
                openFragment(MainFragment.newInstance());
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_main, fragment)
                .commit();
    }

}
