package com.example.cliker.shop.tech;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;

public class TechData {
    public static final int CAPASITY = 3;
    public static TechProcessing techProcessing = BottomActivity.techProcessing;

    public static String[] tech_name = new String[] {
            "Компутер",
            "Ноут",
            "Супер Ноут"
    };

    public static String[] description = new String[] {
            "Твой первый компьютер",
            "Теперь всегда с собой",
            "Теперь ты настоящий программист"
    };

    public static int[] point = new int[] {
            100, 200, 300
    };

    public static int[] image = new int[] {
            R.drawable.comp1,
            R.drawable.comp2,
            R.drawable.comp3
    };

    public static int[] boosts = new int[] {
            1,2,3
    };

    public static String start_value = "false false false";

    public static boolean[] getIsSold() {
        boolean[] booleans = new boolean[CAPASITY];
        String supp = techProcessing.getText();
        String[] s = supp.split(" ");
        for (int i = 0; i < CAPASITY; i++) {
            booleans[i] = Boolean.valueOf(s[i]);
        }
        return booleans;
    }


}
