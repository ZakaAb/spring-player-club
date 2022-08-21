package dz.services.opensmtp.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest()
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testFindById() {
        Player player = getPlayer();
        playerRepository.save(player);
        Player result = playerRepository.findById(player.getId()).get();
        assertEquals(player.getId(), result.getId());
    }

    private Player getPlayer() {
        Player player = new Player();
        player.setId(1L);
        player.setName("zaki");
        player.setAge(29);
        return player;
    }


}
