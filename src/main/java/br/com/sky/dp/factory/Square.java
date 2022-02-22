package br.com.sky.dp.factory;

public class Square implements Shape {
    @Override
    public String draw() {
        String ret = "Drawing a square";
        System.out.println(ret);
        return ret;
    }
}
