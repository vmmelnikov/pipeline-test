package ru.vsu.amm.poiais;

public class Main {
    private Calculator c = new Calculator();
    public static void main(String[] args) {
        System.out.println(new Main().add(Double.valueOf(args[0]), Double.valueOf(args[1]), Double.valueOf(args[2])));
    }

    public Double add(double x, double y, double z) {
        return add(c, x, y, z);
    }

    public Double add(Calculator c, double x, double y, double z) {
        return c.add(c.add(x, y),z);
    }
}