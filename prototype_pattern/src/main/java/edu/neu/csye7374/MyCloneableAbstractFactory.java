package edu.neu.csye7374;

import java.util.HashMap;

public class MyCloneableAbstractFactory extends MyCloneableAbstractFactoryAPI {

    private static final int PROTOTYPE_COUNT = 26;
    private HashMap<Integer, MyCloneable> prototypeList = null;
    private int count = 0;

    {
        prototypeList = new HashMap<>();
        this.count = 0;
        double price = 0.99;
        for(; this.count < PROTOTYPE_COUNT; ++this.count) {
            int i = this.count;
            prototypeList.put(i,
                    new MyCloneableBuilder()
                            .id(i)
                            .name(String.valueOf((char)('A' + i)))
                            .price(++price)
                            .build()
            );
        }
    }

    @Override
    public void load(int id, MyCloneable prototype) {
        this.prototypeList.put(id, prototype);
        System.out.println("Loaded" + prototypeList);
    }

    @Override
    public void load(HashMap<Integer, MyCloneable> prototypeList) {
        this.prototypeList = prototypeList;
    }

    @Override
    public MyCloneable getObject(int id) {
        return prototypeList.get(id).clone();
    }
}
