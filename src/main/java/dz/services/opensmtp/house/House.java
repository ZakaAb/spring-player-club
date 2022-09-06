package dz.services.opensmtp.house;


import dz.services.opensmtp.family.Family;
import lombok.*;

import javax.persistence.*;

@Entity
//@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "house")
    private Family family;
}
