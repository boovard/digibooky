package be.thebest.domain.objects.persons;

public class HasAddress implements Addressable{

    private Address address;

    @Override
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
