package dz.services.opensmtp.club;


import dz.services.opensmtp.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/club")
    public ResponseEntity<Object> AddNewClub(@RequestBody Club club) {
        Club clubAdded  = clubService.addNewClub(club);
        return new ResponseEntity<>(clubAdded, HttpStatus.CREATED);
    }

}
