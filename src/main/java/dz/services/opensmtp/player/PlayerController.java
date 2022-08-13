package dz.services.opensmtp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {


    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/player")
    public Player create(@RequestBody Player player) {
        playerRepository.save(player);
        return player;
    }
}
