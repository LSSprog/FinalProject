package marcet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marcet.model.Address;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long addressId;
    private String region;
    private String city;
    private String street;
    private String houseNumber;
    private Long userId;

    public AddressDTO(Address address) {
        this.addressId = address.getAddressId();
        this.region = address.getRegion();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.userId = address.getUser().getUserId();
    }
}
