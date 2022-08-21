package dz.services.opensmtp.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {


    @Autowired
    private ClubRepository clubRepository;

    public Club addNewClub(Club club) {
        return clubRepository.save(club);
    }
}
