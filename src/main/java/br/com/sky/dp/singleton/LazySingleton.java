package br.com.sky.dp.singleton;

import java.util.Random;

public class LazySingleton implements Singleton {

    private static volatile LazySingleton instance;

    private int value;

    private LazySingleton(){
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

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
