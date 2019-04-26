package com.example.cliker.shop.boost;

import androidx.annotation.Nullable;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;

public class BoostData {

    public static final int CAPASITY = 3;
    public static BoostProcessing boostProcessing = BottomActivity.boostProcessing;

    public static String[] cloth_name = new String[] {
            "Благословение Абрамского",
            "Мозг",
            "Прикольный стикер на ноут"
    };

    public static String[] description = new String[] {
            "Частичка великого",
            "Нужная штука, на алгеме пригодится",
            "Стильно, модно, молодежно"
    };

    public static int[] point = new int[] {
            100, 200, 300
    };

    public static int[] image = new int[] {
            R.drawable.abr,
            R.drawable.brain,
            R.drawable.stiker
    };

    public static int[] boosts = new int[] {
            1,2,3
    };

    public static String start_value = "false false false";


    public static boolean[] getIsSold() {
        boolean[] booleans = new boolean[CAPASITY];
            String supp = boostProcessing.getText();
            String[] s = supp.split(" ");
            for (int i = 0; i < CAPASITY; i++) {
                booleans[i] = Boolean.valueOf(s[i]);
            }
        return booleans;
    }


}
