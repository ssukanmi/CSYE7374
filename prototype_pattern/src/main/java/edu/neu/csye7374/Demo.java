package edu.neu.csye7374;

public class Demo {
    static void demo() {

        for(int i = 0; i < 26; i++) {
            MyCloneable item = MyCloneableAbstractFactorySingleton.getInstance().getObject(i); // returns new object for the id
            System.out.println(
                    "Item ID: " + item.id + "\n" +
                    "Item Name: " + item.name + "\n" +
                    "Item Price: $ " + item.price + "\n"
            );
        }

    }
}
