package com.example.cliker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cliker.clickers.AlgemClick;
import com.example.cliker.clickers.InfaClick;
import com.example.cliker.easypoints.EasyPointFragment;
import com.example.cliker.shop.clothes.WearCLothesProcessing;

import static com.example.cliker.BottomActivity.moneyProcessingAlgem;
import static com.example.cliker.BottomActivity.moneyProcessingAlgemBalance;
import static com.example.cliker.BottomActivity.moneyProcessingFizra;
import static com.example.cliker.BottomActivity.moneyProcessingFizraBalance;
import static com.example.cliker.BottomActivity.moneyProcessingInfa;
import static com.example.cliker.BottomActivity.moneyProcessingInfaBalance;

public class MainFragment extends Fragment implements View.OnClickListener {

    public static int index_image_boy;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        Button easy_point = view.findViewById(R.id.button6);
        easy_point.setOnClickListener(this);
        BottomActivity.count_fizra = Integer.parseInt(moneyProcessingFizraBalance.getText());
        BottomActivity.count_infa = Integer.parseInt(moneyProcessingInfaBalance.getText());
        BottomActivity.count_algem = Integer.parseInt(moneyProcessingAlgemBalance.getText());
        index_image_boy = Integer.parseInt(BottomActivity.wearCLothesProcessing.getText());
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView fizra = getActivity().findViewById(R.id.fizre_count);
        TextView algem = getActivity().findViewById(R.id.algem_count);
        TextView infa = getActivity().findViewById(R.id.infa_count);
        ImageView boy = getActivity().findViewById(R.id.iv_boy);
        boy.setImageResource(index_image_boy);
        fizra.setText(BottomActivity.count_fizra + "");
        algem.setText(BottomActivity.count_algem + "");
        infa.setText(BottomActivity.count_infa + "");
    }


    @Override
    public void onClick(View v) {
        openFragment(EasyPointFragment.newInstance());
    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main, fragment)
        .commit();
    }

}
