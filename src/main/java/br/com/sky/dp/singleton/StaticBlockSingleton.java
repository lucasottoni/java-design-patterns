package br.com.sky.dp.singleton;

import java.util.Random;

public class StaticBlockSingleton implements Singleton {
    private int value;

    private static final StaticBlockSingleton instance;

    static {
        instance = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {
        Random r = new Random();
        this.value = r.nextInt();
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void addValue(int v) {
        this.value += v;
    }
}
