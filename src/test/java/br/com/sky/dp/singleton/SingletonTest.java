package br.com.sky.dp.singleton;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SingletonTest {

    @Test
    public void eager() {
        EagerSingleton singleton1 = EagerSingleton.getInstance();
        EagerSingleton singleton2 = EagerSingleton.getInstance();
        EagerSingleton singleton3 = EagerSingleton.getInstance();

        testSingleton(singleton1, singleton2, singleton3);
    }

    @Test
    public void eagerThreaded() throws InterruptedException {
        ThreadRunner tr1 = new ThreadRunner(EagerSingleton::getInstance);
        ThreadRunner tr2 = new ThreadRunner(EagerSingleton::getInstance);
        ThreadRunner tr3 = new ThreadRunner(EagerSingleton::getInstance);

        testThreaded(tr1, tr2, tr3);
    }

    @Test
    public void lazy() {
        Singleton singleton1 = LazySingleton.getInstance();
        Singleton singleton2 = LazySingleton.getInstance();
        Singleton singleton3 = LazySingleton.getInstance();

        testSingleton(singleton1, singleton2, singleton3);
    }

    @Test
    public void lazyThreaded() throws InterruptedException {
        ThreadRunner tr1 = new ThreadRunner(LazySingleton::getInstance);
        ThreadRunner tr2 = new ThreadRunner(LazySingleton::getInstance);
        ThreadRunner tr3 = new ThreadRunner(LazySingleton::getInstance);

        testThreaded(tr1, tr2, tr3);
    }

    @Test
    public void staticBlock() {
        Singleton singleton1 = StaticBlockSingleton.getInstance();
        Singleton singleton2 = StaticBlockSingleton.getInstance();
        Singleton singleton3 = StaticBlockSingleton.getInstance();

        testSingleton(singleton1, singleton2, singleton3);
    }

    @Test
    public void staticBlockThreaded() throws InterruptedException {
        ThreadRunner tr1 = new ThreadRunner(StaticBlockSingleton::getInstance);
        ThreadRunner tr2 = new ThreadRunner(StaticBlockSingleton::getInstance);
        ThreadRunner tr3 = new ThreadRunner(StaticBlockSingleton::getInstance);

        testThreaded(tr1, tr2, tr3);
    }

    @Test
    public void enumSingleton() {
        Singleton singleton1 = EnumSingleton.INSTANCE;
        Singleton singleton2 = EnumSingleton.INSTANCE;
        Singleton singleton3 = EnumSingleton.INSTANCE;

        testSingleton(singleton1, singleton2, singleton3);
    }

    @Test
    public void enumThreaded() throws InterruptedException {
        ThreadRunner tr1 = new ThreadRunner(() -> EnumSingleton.INSTANCE);
        ThreadRunner tr2 = new ThreadRunner(() -> EnumSingleton.INSTANCE);
        ThreadRunner tr3 = new ThreadRunner(() -> EnumSingleton.INSTANCE);

        testThreaded(tr1, tr2, tr3);
    }

    private void testSingleton(Singleton singleton1, Singleton singleton2, Singleton singleton3) {
        assertEquals(singleton1, singleton2);
        assertEquals(singleton2, singleton3);

        assertEquals(singleton1.getValue(), singleton3.getValue());
        assertEquals(singleton2.getValue(), singleton3.getValue());

        int value = singleton1.getValue();
        singleton1.addValue(10);
        assertEquals(value + 10, singleton1.getValue());
        assertEquals(value + 10, singleton3.getValue());
        assertEquals(value + 10, singleton3.getValue());

        singleton2.addValue(15);
        assertEquals(value + 25, singleton1.getValue());
        assertEquals(value + 25, singleton3.getValue());
        assertEquals(value + 25, singleton3.getValue());

        singleton3.addValue(25);
        assertEquals(value + 50, singleton1.getValue());
        assertEquals(value + 50, singleton3.getValue());
        assertEquals(value + 50, singleton3.getValue());

    }

    private void testThreaded(ThreadRunner tr1, ThreadRunner tr2, ThreadRunner tr3) throws InterruptedException {
        assertNull(tr1.singleton);
        assertNull(tr2.singleton);
        assertNull(tr3.singleton);

        Thread t1 = new Thread(tr1);
        Thread t2 = new Thread(tr2);
        Thread t3 = new Thread(tr3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Singleton singleton1 = tr1.singleton;
        Singleton singleton2 = tr2.singleton;
        Singleton singleton3 = tr3.singleton;

        testSingleton(singleton1, singleton2, singleton3);
    }


    static class ThreadRunner implements Runnable {
        private Singleton singleton;
        private final Supplier<Singleton> creator;

        public ThreadRunner(Supplier<Singleton> creator) {
            this.creator = creator;
        }

        @Override
        public void run() {
            singleton = creator.get();
        }
    }
}
