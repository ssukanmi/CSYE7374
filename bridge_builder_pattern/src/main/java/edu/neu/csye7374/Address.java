package edu.neu.csye7374;

public class Address {
    public String street;
    public String city;
    public String state;
    public String postalCode;
    public String country;

    public Address(AddressBuilder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
    }

    @Override
    public String toString() {
        return street + "\n" + city + ", " + state + ", " + postalCode + "\n" + country;
    }
}

