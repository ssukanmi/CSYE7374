package edu.neu.csye7374;

public class Employee extends Person implements EmployeeAPI {
    private int age;
    private String name;
    private String job;
    private double wage;

    @Override
    public double getWage() {
        return wage;
    }

    @Override
    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String getJob() {
        return job;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
