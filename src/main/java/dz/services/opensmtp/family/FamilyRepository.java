package dz.services.opensmtp.family;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

    List<Family> findByHouseName(String name);

    @Query("FROM Family WHERE house.name = :name")
    List<Family> getFamilyByHouse(String name);
}
