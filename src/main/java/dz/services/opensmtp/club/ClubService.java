package dz.services.opensmtp.club;

import dz.services.opensmtp.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {


    @Autowired
    private ClubRepository clubRepository;

    public Club addNewClub(Club club) {
        return clubRepository.save(club);
    }

    public Optional<Club> getClub(Long clubId) {
        return clubRepository.findById(clubId);
    }

    public List<Player> getPlayersOfClub(Long clubId) {
        Optional<Club> club = clubRepository.findById(clubId);
        return club.get().getPlayers();
    }
}
