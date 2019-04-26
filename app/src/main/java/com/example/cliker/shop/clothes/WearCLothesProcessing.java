package com.example.cliker.shop.clothes;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cliker.R;

import java.io.IOException;

public class WearCLothesProcessing {


    Context context;

    public String myMoney = "myMoney";

    public static final String WEAR_CLOTHE = "cloth";
    public static final String nameKey = "wear_cloth";

    private SharedPreferences sharedPrefs;

    public WearCLothesProcessing(Context context) throws IOException {
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
        sharedPrefs = context.getSharedPreferences(WEAR_CLOTHE, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey)) {
            return (sharedPrefs.getString(nameKey, ""));
        } return "" + R.drawable.boy;
    }


}
