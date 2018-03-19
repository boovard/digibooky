package be.thebest.domain.objects.persons;

public class Address {

    private String streetName;
    private String houseNumber;
    private String postCode;
    private String city;

    public Address(String streetName, String houseNumber, String postCode, String city) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public Address(String city) {
        this.city = city;
    }

    public Address(String postCode, String city) {
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
