package br.com.sky.dp.factory;

public class Rectangle implements Shape {
    @Override
    public String draw() {
        String ret = "Drawing a rectangle";
        System.out.println(ret);
        return ret;
    }
}
