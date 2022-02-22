package br.com.sky.dp.singleton;

import java.util.Random;

public enum EnumSingleton implements Singleton {
    INSTANCE();

    private int value;

    EnumSingleton() {
        Random r = new Random();
        this.value = r.nextInt();
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
