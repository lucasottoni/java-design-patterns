package br.com.sky.dp.singleton;

import java.util.Random;

public class EagerSingleton implements Singleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private int value;

    private EagerSingleton(){
        Random r = new Random();
        value = r.nextInt();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void addValue(int v) {
        this.value += v;
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
