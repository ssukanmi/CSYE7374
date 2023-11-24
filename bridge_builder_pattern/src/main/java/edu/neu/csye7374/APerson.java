package edu.neu.csye7374;

public class APerson implements ArticulatePersonAPI {
    private PersonAPI implementor;

    public APerson(PersonAPI implementor) {
        this.implementor = implementor;
    }

    @Override
    public void talk() {
        System.out.println("Hi! my name is " + implementor.getName() + "! I am " + implementor.getAge() + " years old. It's nice meeting you.");
    }
}
