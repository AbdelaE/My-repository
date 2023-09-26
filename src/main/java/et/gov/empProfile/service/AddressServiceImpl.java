package et.gov.empProfile.service;

import et.gov.empProfile.dto.AddressDto;
import et.gov.empProfile.entity.Address;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(int id) throws DataNotFoundException {
        Address address =  addressRepository.findById(id).orElse(null);
        if (address ==null){
            throw  new DataNotFoundException("there is no data with id---" +id);
        }
        return address;
    }

    @Override
    public Address updateAddress(Address address) throws DataNotFoundException {
        Address savedAddress = addressRepository.findById(address.getId()).orElse(null);
        if (savedAddress == null){
            throw new DataNotFoundException("there is no data with id---" +address.getId());
        }
        savedAddress.setCity(address.getCity());
        savedAddress.setSubCity(address.getSubCity());
        savedAddress.setEmail(address.getEmail());
        savedAddress.setPhoneNo(address.getPhoneNo());
        return addressRepository.save(savedAddress);
    }

    @Override
    public void saveAddressDto(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> allAddressByCityUsingJPQL(String city) {
        return addressRepository.allAddressByCityUsingJPQL(city);
    }

    @Override
    public List<Address> allAddressUsingJPQL() {
        return addressRepository.allAddressUsingJPQL();
    }

    @Override
    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

}
