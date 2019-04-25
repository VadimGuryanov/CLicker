package com.example.cliker.money;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MoneyProcessing {

    int algemMoney, fizraMoney, infaMoney;

    public MoneyProcessing(AssetManager assets) throws IOException {
        readMoneyFile(assets);
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

    public void readMoneyFile(AssetManager assets) throws IOException {

        try {
            BufferedReader bufferedReaderAlgem = new BufferedReader(
                    new InputStreamReader(
                            assets.open("algemMoney.txt"))

            );
            setAlgemMoney(algemMoney = Integer.parseInt(bufferedReaderAlgem.readLine()));
            bufferedReaderAlgem.close();
            BufferedReader bufferedReaderFizra = new BufferedReader(
                    new InputStreamReader(
                            assets.open("fizraMoney.txt"))

            );
            setFizraMoney(fizraMoney = Integer.parseInt(bufferedReaderFizra.readLine()));
            bufferedReaderFizra.close();
            BufferedReader bufferedReaderInfa = new BufferedReader(
                    new InputStreamReader(
                            assets.open("infaMoney.txt"))

            );
            setInfaMoney(infaMoney = Integer.parseInt(bufferedReaderInfa.readLine()));
            bufferedReaderInfa.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   /* public void saveClick(AssetManager assets) throws IOException {
        FileWriter fileWriterAlgemDelete = new FileWriter(String.valueOf(assets.open("algemMoney.txt")));
        fileWriterAlgemDelete.write(String.valueOf(assets.open("algemMoney.txt")));
        fileWriterAlgemDelete.close();
        FileWriter fileWriterInfaDelete = new FileWriter(get);
        fileWriterInfaDelete.write("");
        fileWriterInfaDelete.close();
        FileWriter fileWriterFizraDelete = new FileWriter(String.valueOf(assets.open("fizraMoney.txt")));
        fileWriterFizraDelete.write("");
        fileWriterFizraDelete.close();
        FileWriter fileWriterAlgem = new FileWriter(String.valueOf(assets.open("algemMoney.txt")), true);
        fileWriterAlgem.write(getAlgemMoney());
        fileWriterAlgem.close();
        FileWriter fileWriterInfa = new FileWriter(String.valueOf(assets.open("infaMoney.txt")), true);
        fileWriterInfa.write(getInfaMoney());
        fileWriterInfa.close();
        FileWriter fileWriterFizra = new FileWriter(String.valueOf(assets.open("fizraMoney.txt")), true);
        fileWriterFizra.write(getFizraMoney());
        fileWriterFizra.close();

    }*/
}
