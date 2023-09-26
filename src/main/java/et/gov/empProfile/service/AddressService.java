package et.gov.empProfile.service;

import et.gov.empProfile.dto.AddressDto;
import et.gov.empProfile.entity.Address;
import et.gov.empProfile.exception.DataNotFoundException;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);

    List<Address> findAll();

    Address findById(int id) throws DataNotFoundException;

    Address updateAddress(Address address) throws DataNotFoundException;


    void saveAddressDto(Address address);

    List<Address> allAddressByCityUsingJPQL(String city);

    public List<Address> allAddressUsingJPQL();

    void deleteAddressById(int id);
}
