package marcet.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcet.dto.AddressDTO;
import marcet.repository.AddressRepository;
import marcet.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

//    @PostMapping("/username")
//    private List<AddressDTO> getAdressNoUserName(@RequestBody String userName){
//        log.info("UserName " + userName);
//        return addressService.getAdressNoUserName(userName);
//    }

    @GetMapping("/{username}") //LSS получение списка всех адресов юзера
    public List<AddressDTO> getAddressesByUsername(@PathVariable String username) {
        return addressService.getAddressByUser(username);
    }

    @PostMapping //LSS добавление нового адреса юзеру
    public List<AddressDTO> addNewAddress(@RequestBody AddressDTO address, @RequestParam(name = "username") String username) {
        addressService.addNewAddress(address, username);
        return addressService.getAddressByUser(username);
    }
}
