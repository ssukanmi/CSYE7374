package edu.neu.csye7374;

public class BridgeDemo {
    public static void demo() {
        System.out.println("\n-------Bridge Demo------");
        PersonAPI person = new Person();
        person.setName("Nimish");
        person.setAge(27);

        EmployeeAPI employee = new Employee();
        employee.setName("Ola");
        employee.setAge(26);
        employee.setJob("Software Engineer");
        employee.setWage(80);

        ArticulatePersonAPI articulatePerson = new APerson(person);
        AmbulatePersonAPI ambulatePerson = new BPerson(person);
        AmbulatePersonAPI ambulateEmployee = new CPerson(employee);

        System.out.println("Articulate Person: ");
        articulatePerson.talk();

        System.out.println("\nAmbulate Person: ");
        ambulatePerson.talk();
        ambulatePerson.walk();
        ambulatePerson.jump();

        System.out.println("\nAmbulate Employee:");
        ambulateEmployee.talk();
        ambulateEmployee.walk();
        ambulateEmployee.jump();
    }
}
