package br.com.sky.dp.factory;

public class Circle implements Shape {
    @Override
    public String draw() {
        String ret = "Drawing a circle";
        System.out.println(ret);
        return ret;
    }
}
