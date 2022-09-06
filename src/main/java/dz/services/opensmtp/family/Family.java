package dz.services.opensmtp.family;


import dz.services.opensmtp.house.House;
import dz.services.opensmtp.request.FamilyRequest;
import lombok.*;

import javax.persistence.*;

@Entity
//@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private House house;

    public Family(FamilyRequest req) {
        this.name = req.getName();
    }
}
