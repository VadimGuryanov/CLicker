package com.example.cliker.shop.boost;

import androidx.annotation.Nullable;

import com.example.cliker.R;

public class BoostData {

    public static final int CAPASITY = 3;

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
}
