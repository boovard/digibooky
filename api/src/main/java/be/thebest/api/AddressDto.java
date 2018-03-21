package be.thebest.api;

public class AddressDto {

    private String streetName;
    private String houseNumber;
    private String postCode;
    private String city;

    public static AddressDto addressDto() {
        return new AddressDto();
    }

    public AddressDto withStreetName(String streetName){
        this.streetName = streetName;
        return this;
    }

    public AddressDto withHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressDto withpostCode(String postCode){
        this.postCode = postCode;
        return this;
    }

    public AddressDto withCity(String city){
        this.city = city;
        return this;
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
