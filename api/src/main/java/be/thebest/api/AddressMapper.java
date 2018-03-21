package be.thebest.api;

import be.thebest.domain.objects.persons.Address;

public class AddressMapper {

    public AddressDto toDto(Address address) {
        return AddressDto.addressDto()
                .withStreetName(address.getStreetName())
                .withHouseNumber(address.getHouseNumber())
                .withpostCode(address.getPostCode())
                .withCity(address.getCity());
    }

    public Address toDomain(AddressDto addressDto) {
        return Address.AddressBuilder.address()
                .withStreetName(addressDto.getStreetName())
                .withHouseNumber(addressDto.getHouseNumber())
                .withPostCode(addressDto.getPostCode())
                .withCity(addressDto.getCity())
                .build();
    }
}
