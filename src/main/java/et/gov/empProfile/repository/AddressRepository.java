package et.gov.empProfile.repository;

import et.gov.empProfile.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "select a from Address a where a.city=:c")
    public List<Address> allAddressByCityUsingJPQL(@Param("c") String city);

    @Query("select a from Address a ")
    public List<Address> allAddressUsingJPQL();
}
