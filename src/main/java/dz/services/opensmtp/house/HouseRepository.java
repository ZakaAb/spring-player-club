package dz.services.opensmtp.house;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query(value = "select * from house", nativeQuery = true)
    List<House> getHouses();

}
