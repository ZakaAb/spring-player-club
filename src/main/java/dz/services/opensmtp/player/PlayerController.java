package dz.services.opensmtp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {


    @Autowired
    PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity<Object> createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
        return new ResponseEntity<>("Player is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/player")
    public ResponseEntity<Object> getAllPlayer() {
        List<Player> listOfPlayers = playerService.getAllPlayer();
        System.out.println(listOfPlayers);
        return new ResponseEntity<>(listOfPlayers, HttpStatus.OK);
    }
}
