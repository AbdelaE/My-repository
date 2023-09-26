package et.gov.empProfile.controller;

import et.gov.empProfile.dto.AddressDto;
import et.gov.empProfile.entity.Address;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @PostMapping("/saveAddress")
    public ResponseEntity<Address> saveAddress(@RequestBody @Valid Address address) {
    /*    Employee employee = new Employee();
        address.setEmpId(employee);*/
        Address saveAddress = addressService.saveAddress(address);
        return new ResponseEntity<>(saveAddress, HttpStatus.CREATED);
    }

    @PostMapping("/saveAddressDto")
    public ResponseEntity<AddressDto> saveAddressDto(@RequestBody Address address) {
        addressService.saveAddressDto(address);
        AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(address,addressDto);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/allAddress")
    public ResponseEntity<List<Address>> allAddress() {
        List<Address> listOfAddress = addressService.findAll();
        return new ResponseEntity<>(listOfAddress, HttpStatus.OK);
    }

    @GetMapping("/adderessById/{id}")
    public ResponseEntity<Address> findById(@PathVariable("id") int id) throws DataNotFoundException {
        Address addessById = addressService.findById(id);
        return new ResponseEntity<>(addessById, HttpStatus.OK);
    }
    @GetMapping("/allAddressByCityUsingJPQL/{city}")
    public ResponseEntity<List<Address>> allAddressByCityUsingJPQL(@PathVariable String city) {
        List<Address> addessByCity = addressService.allAddressByCityUsingJPQL(city);
        return new ResponseEntity<>(addessByCity, HttpStatus.OK);
    }
    @GetMapping("/allAddressUsingJPQL")
    public ResponseEntity<List<Address>> allAddressUsingJPQL() {
        List<Address> addessByCity = addressService.allAddressUsingJPQL();
        return new ResponseEntity<>(addessByCity, HttpStatus.OK);
    }

    @PutMapping("/updateAddressById/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody @Valid Address address) throws DataNotFoundException {
        address.setId(id);
        Address updateAddress = addressService.updateAddress(address);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }
    @DeleteMapping("/deleteAddressById/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable int id){
        addressService.deleteAddressById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
