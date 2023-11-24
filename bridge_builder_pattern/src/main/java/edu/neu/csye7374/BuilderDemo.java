package edu.neu.csye7374;

public class BuilderDemo {
    public static void demo() {
        System.out.println("\n-------Builder Demo------");
        Address address = new AddressBuilder()
                .street("10 Serge St")
                .city("Boston")
                .state("Massachusetts")
                .country("United States")
                .postalCode("02150")
                .build();
        System.out.println(address.toString());
    }
}
