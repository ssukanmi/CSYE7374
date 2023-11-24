package edu.neu.csye7374;

public class CPerson implements AmbulatePersonAPI {
    private EmployeeAPI implementor;

    public CPerson(EmployeeAPI implementor) {
        this.implementor = implementor;
    }

    @Override
    public void walk() {
        System.out.println(implementor.getName() + " Walking...");
    }

    @Override
    public void run() {
        System.out.println(implementor.getName() + " Running...");
    }

    @Override
    public void jump() {
        System.out.println(implementor.getName() + " Jumped...");
    }

    @Override
    public void talk() {
        System.out.println("Hi! my name is " + implementor.getName() + "! I am " + implementor.getAge() + " years old. It's nice meeting you.");
    }
}
