package com.example.cliker.easypoints;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

public class EventProcessing {

    Context context;

    public String myMoney = "myMoney";

    public static final String ALGEM = "boost";
    public static final String nameKey = "algem_boost";

    private SharedPreferences sharedPrefs;

    public EventProcessing(Context context) throws IOException {
        this.context = context;
    }


    // метод для сохранения текста в файл настроек
    public void saveText(String value) {
        // получаем текст
//        String editTextValue = editText.getText().toString();

        // получаем доступ к файлу
        SharedPreferences.Editor editor = sharedPrefs.edit();
        // сохраняем по текст из EditText по ключу nameKey
        editor.putString(nameKey, value);
        editor.apply();
    }

    // метод для получения текста из SharedPreferences по ключу
    public String getText() {
        sharedPrefs = context.getSharedPreferences(ALGEM, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey)) {
            return (sharedPrefs.getString(nameKey, ""));
        } return EventsData.start_value;
    }

}
