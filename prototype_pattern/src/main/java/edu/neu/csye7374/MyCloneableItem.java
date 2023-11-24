package edu.neu.csye7374;

public class MyCloneableItem extends MyCloneable {
    public MyCloneableItem(int id, double price, String name) {
        super(id, price, name);
    }
    @Override
    public MyCloneableItem clone() {
        return new MyCloneableItem(this.id, this.price, this.name);
    }
}
