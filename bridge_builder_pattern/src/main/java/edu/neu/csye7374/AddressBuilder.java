package edu.neu.csye7374;

public class AddressBuilder {
    public String street = null;
    public String city = null;
    public String state = null;
    public String postalCode = null;
    public String country= null;

    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder state(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder country(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        return new Address(this);
    }
}
