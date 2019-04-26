package com.example.cliker.shop.clothes;

import com.example.cliker.BottomActivity;
import com.example.cliker.R;


public class ClothData {

    public static final int CAPASITY = 3;
    public static ClothesProcessing clothesProcessing = BottomActivity.clothesProcessing;
    public static WearCLothesProcessing wearCLothesProcessing = BottomActivity.wearCLothesProcessing;

    public static String[] cloth_name = new String[] {
            "Футболка",
            "Футболка",
            "Футболка"
    };

    public static String[] description = new String[] {
            "Будь на нужной волне!",
            "В ней можно и к Корнеевой",
            "Для уважаемых персон"
    };

    public static int[] point = new int[] {
            100, 200, 300
    };

    public static int[] image = new int[] {
            R.drawable.t_rainbow,
            R.drawable.t_polo,
            R.drawable.t_fff
    };

    public static int[] image_boy = new int[] {
            R.drawable.boy_rainbow,
            R.drawable.boy_polo,
            R.drawable.boy_fff
    };

    public static boolean[] getIsSold() {
        boolean[] booleans = new boolean[CAPASITY];
        String supp = clothesProcessing.getText();
        String[] s = supp.split(" ");
        for (int i = 0; i < CAPASITY; i++) {
            booleans[i] = Boolean.valueOf(s[i]);
        }
        return booleans;
    }

}
