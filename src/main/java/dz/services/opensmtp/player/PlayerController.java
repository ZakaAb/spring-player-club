package dz.services.opensmtp.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {


    @Autowired
    PlayerService playerService;

    @PostMapping("/player/add/{clubId}")
    public ResponseEntity<Object> createPlayer(@RequestBody Player player,@PathVariable("clubId") Long clubId) {
        Optional<Player> playerCreated  = playerService.createPlayer(player, clubId);
        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

    @PutMapping("/player/{id}/club/{clubId}")
    public ResponseEntity<Object> updatePlayer(@PathVariable("id") Long id,@PathVariable("clubId") Long clubId) {
        Optional<Player> playerCreated  = playerService.addPlayerToClub(id, clubId);
        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

    @PostMapping("/player")
    public ResponseEntity<Object> addPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.saveOrUpdate(player), HttpStatus.CREATED);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Object> getPlayerById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);
    }

    @GetMapping("/player/all")
    public ResponseEntity<Object> getAllPlayer() {
        return new ResponseEntity<>(playerService.getAllPlayer(), HttpStatus.OK);
    }

    @GetMapping("/player/all/{name}")
    public ResponseEntity<Object> getPlayerByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(playerService.findByName(name), HttpStatus.OK);
    }

//    @PutMapping("/player/{id}")
//    public ResponseEntity<Object> updatePlayerWithId(@PathVariable("id") Long id, @RequestBody Player player) {
//        String name = player.getName();
//        int age = player.getAge();
//        playerService.updatePlayer(id, name, age);
//        return new ResponseEntity<>("Player updated successfully!", HttpStatus.OK);
//    }

    @PutMapping("/player")
    public ResponseEntity<Object> updatePlayer(@RequestBody Player player) {
        playerService.saveOrUpdate(player);
        return new ResponseEntity<>("Player is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Object> deletePlayerWithId(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);

        return new ResponseEntity<>("Player deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/player/age/{age}")
    public ResponseEntity<Object> getPlayerWithAge(@PathVariable("age") int age) {
        return new ResponseEntity<>(playerService.findPlayerByAge(age), HttpStatus.OK);
    }

    @GetMapping("/player/all/sorted")
    public ResponseEntity<Object> getPlayerSortedByName() {
        return new ResponseEntity<>(playerService.findAllPlayerSortedByName(), HttpStatus.OK);
    }

    @GetMapping("/player/all/limit/{limit}")
    public ResponseEntity<Object> getAllByLimit(@PathVariable("limit") int limit) {
        return new ResponseEntity<>(playerService.findAllByLimit(limit, "age"), HttpStatus.OK);
    }
}
