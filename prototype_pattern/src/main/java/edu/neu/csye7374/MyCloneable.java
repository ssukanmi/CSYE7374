package edu.neu.csye7374;

public class MyCloneable implements Cloneable {
    public int id;
    public double price;
    public String name;

    public MyCloneable(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public MyCloneable clone() {
        return new MyCloneable(id, price, name);
    }
}
