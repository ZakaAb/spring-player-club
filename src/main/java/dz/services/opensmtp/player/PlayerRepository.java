package dz.services.opensmtp.player;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public List<Player> findByName(String name);
    public Player findByAge(int age);

    @Query(value = "SELECT p FROM Player p ORDER BY name")
    public List<Player> findAllPlayerSortedByName();

    @Query(value = "SELECT * FROM Player", nativeQuery = true)
    public List<Player> findAllByLimit(Pageable p);
}
