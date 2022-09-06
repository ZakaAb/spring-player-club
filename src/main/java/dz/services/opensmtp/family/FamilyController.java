package dz.services.opensmtp.family;


import dz.services.opensmtp.house.House;
import dz.services.opensmtp.house.HouseRepository;
import dz.services.opensmtp.request.FamilyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    HouseRepository houseRepository;

    @PostMapping("/family")
    public ResponseEntity<Family> saveFamily(@RequestBody FamilyRequest fRequest) {
        House house = new House();
        house.setName(fRequest.getHouse());

        house = houseRepository.save(house);

        Family family = new Family(fRequest);
        family.setHouse(house);

        family = familyRepository.save(family);

        return new ResponseEntity<Family>(family, HttpStatus.CREATED);
    }

    @GetMapping("/family")
    public ResponseEntity<List<Family>> getFamilyByHouse(@RequestParam String name) {
        return new ResponseEntity<List<Family>>(familyRepository.findByHouseName(name), HttpStatus.OK);
    }
}
