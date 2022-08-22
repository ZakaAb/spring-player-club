package dz.services.opensmtp.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import dz.services.opensmtp.club.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NamedQuery(name="Player.findByAge", query = "SELECT name FROM Player p WHERE p.age = ?1")
// @NamedQuery(name="Player.findByAge", query = "SELECT p FROM Player p WHERE p.age = ?1")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    // @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "club_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Club club;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(int  age) {
        this.age = age;
    }

    public Player(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
