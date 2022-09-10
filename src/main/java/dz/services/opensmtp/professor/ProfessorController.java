package dz.services.opensmtp.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("/professor/{id}")
    public ResponseEntity<Object> getProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        System.out.println(professor.isPresent());
        return professor.isPresent()
                ? new ResponseEntity<Object>(professor.get(), HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/professor")
    public ResponseEntity<List<Professor>> getAllProfessors() {
        try {
            List<Professor> professors = professorRepository.findAll();
            return new ResponseEntity<>(professors, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
