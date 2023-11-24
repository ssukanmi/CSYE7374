package edu.neu.csye7374;

public class MyCloneableBuilder {
    public int id;
    public double price;
    public String name;

    {
        this.id = 0;
        this.price = 0;
        this.name = "";
    }

    public MyCloneableBuilder id(int id) {
        this.id = id;
        return this;
    }

    public MyCloneableBuilder price(double price) {
        this.price = price;
        return this;
    }

    public MyCloneableBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MyCloneableItem build() {
        return new MyCloneableItem(this.id, this.price, this.name);
    }
}
