package com.example.cliker.easypoints;

import com.example.cliker.R;

public class EventsData {

    public static final int CAPACITY = 4;

    public static String[] event_name = new String[] {
            "Медосмотр",
            "Концерт",
            "Спорт",
            "Студенческая весна"
    };

    public static String[] description = new String[] {
            "Помочь студентам пройти медосмотр!",
            "Поддержать наш институт на концерте!",
            "Болеем за нашу сборную!",
            "Если ты музыкант, художник или певец, то это для тебя!\nВыступай за ИТИС!"
    };

    public static int[] point = new int[] {
            100, 200, 50, 300
    };

    public static int[] image = new int[] {
            R.drawable.f_itis,
            R.drawable.teatr,
            R.drawable.sport,
            R.drawable.stud_vesna,
    };
}
