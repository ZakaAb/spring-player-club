package dz.services.opensmtp.club;


import dz.services.opensmtp.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/club")
    public ResponseEntity<Object> AddNewClub(@RequestBody Club club) {
        Club clubAdded  = clubService.addNewClub(club);
        return new ResponseEntity<>(clubAdded, HttpStatus.CREATED);
    }

    @GetMapping("/club/{id}")
    public ResponseEntity<Object> getClubWithId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clubService.getClub((id)), HttpStatus.OK);
    }

    @GetMapping("/club/{id}/players")
    public ResponseEntity<Object> getPlayersOfClub(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clubService.getPlayersOfClub((id)), HttpStatus.OK);
    }

}
