package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");
        //Add your code in between these two print statements
        BridgeDemo.demo();
        BuilderDemo.demo();
        System.out.println("\n\n============Main Execution End===================");
    }
}


/*
-------Bridge Demo------
Articulate Person:
Hi! my name is Nimish! I am 27 years old. It's nice meeting you.

Ambulate Person:
Hi! my name is Nimish! I am 27 years old. It's nice meeting you.
Nimish Walking...
Nimish Jumped...

Ambulate Employee:
Hi! my name is Ola! I am 26 years old. It's nice meeting you.
Ola Walking...
Ola Jumped...

-------Builder Demo------
10 Serge St
Boston, Massachusetts, 02150
United States
*/