package com.example.cliker.money;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

public class MoneyProcessingInfa {

    Context context;

    int algemMoney, fizraMoney, infaMoney;
    public String myMoney = "myMoney";

    public static final String INFA = "myprs";
    public static final String nameKey = "infa";

    private SharedPreferences sharedPrefs;

    public MoneyProcessingInfa(Context context) throws IOException {
        this.context = context;
    }

    public int getAlgemMoney() {
        return algemMoney;
    }

    public void setAlgemMoney(int algemMoney) {
        this.algemMoney = algemMoney;
    }

    public void setFizraMoney(int fizraMoney) {
        this.fizraMoney = fizraMoney;
    }

    public void setInfaMoney(int infaMoney) {
        this.infaMoney = infaMoney;
    }

    public int getFizraMoney() {
        return fizraMoney;
    }

    public int getInfaMoney() {
        return infaMoney;
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
        sharedPrefs = context.getSharedPreferences(INFA, Context.MODE_PRIVATE);
        if (sharedPrefs.contains(nameKey)) {
            return (sharedPrefs.getString(nameKey, ""));
        } return "0";
    }
}
