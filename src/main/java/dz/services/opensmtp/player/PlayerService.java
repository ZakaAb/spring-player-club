package dz.services.opensmtp.player;

import dz.services.opensmtp.club.Club;
import dz.services.opensmtp.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClubRepository clubRepository;

    public Optional<Player> createPlayer(Player player, Long clubId) {
        return clubRepository.findById(clubId).map(club -> {
            player.setClub(club);
            return playerRepository.save(player);
        });
    }

    public List<Player> getAllPlayer() {
        List<Player> players = new ArrayList<Player>();
        playerRepository.findAll().forEach(player -> players.add(player));
        return players;
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).get();
    }

    public void updatePlayer(Long id, String name, int age) {
        Optional<Player> OptionalPlayer = playerRepository.findById(id);
        if(OptionalPlayer.isPresent()) {
            Player player = OptionalPlayer.get();
            player.setName(name);
            player.setAge(age);
            playerRepository.save(player);
        }
    }

    public Player saveOrUpdate(Player player) {
        /* Long idClub = Long.valueOf(1);
        Optional<Club> club = clubRepository.findById(idClub);
        player.setClub(club.orElse(null)); */
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public List<Player> findByName(String name) {
        return playerRepository.findByName(name);
    }

    public Player findPlayerByAge(int age) {
        return playerRepository.findByAge(age);
    }

    public List<Player> findAllPlayerSortedByName() {
        return playerRepository.findAllPlayerSortedByName();
    }

    public List<Player> findAllByLimit(int limit, String order) {
        return playerRepository.findAllByLimit(PageRequest.of(0, limit, Sort.Direction.ASC  , order));
    }

    public Optional<Player> addPlayerToClub(Long id, Long clubId) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            Optional<Club> club = clubRepository.findById(clubId);
            if(club.isPresent()) {
                player.get().setClub(club.get());
                playerRepository.save(player.get());
            }
        }
        return playerRepository.findById(id);
    }
}
