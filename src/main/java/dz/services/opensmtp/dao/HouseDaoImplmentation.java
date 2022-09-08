package dz.services.opensmtp.dao;


import dz.services.opensmtp.house.House;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HouseDaoImplmentation {


    @PersistenceContext
    private EntityManager manager;

    public List<House> getAll () {
        return manager.createNamedQuery("getAllRecords", House.class).getResultList();
    }
}
