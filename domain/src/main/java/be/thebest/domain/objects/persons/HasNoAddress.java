package be.thebest.domain.objects.persons;

public class HasNoAddress implements Addressable{


    @Override
    public Address getAddress() {
        return null;
    }

    @Override
    public void setAddress(Address address) {

    }
}
