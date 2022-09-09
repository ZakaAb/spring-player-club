package dz.services.opensmtp.house;


import dz.services.opensmtp.dao.HouseDaoImplmentation;
import dz.services.opensmtp.response.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseDaoImplmentation hDao;

    @GetMapping("/houses")
    public List<HouseResponse> getHouses() {
        List<House> houses = houseRepository.findAll();
        List<HouseResponse> list = new ArrayList<>();

        houses.forEach(h -> {
            HouseResponse hResponse = new HouseResponse();
            hResponse.setHouseName(h.getName());
            hResponse.setId(h.getId());
            hResponse.setFamilyName(h.getFamily().getName());
            list.add(hResponse);
        });

        return list;
    }

    /*
     Native Query
     */
    /*
      *  @GetMapping("/house/all")
        public List<House> getHousesAll() {
        return houseRepository.getHouses();
        }
    */

    /*
      *  @GetMapping("/house/all")
      * public List<House> getHousesALl() {
      *     return hDao.getAll();
      *  }
    */

    @GetMapping("/house/all")
    public List<House> getHousesALl() {
        return houseRepository.getAllRecords();
    }
}
