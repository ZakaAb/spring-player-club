package dz.services.opensmtp.subject;

import dz.services.opensmtp.exception.NotFoundException;
import dz.services.opensmtp.professor.Professor;
import dz.services.opensmtp.professor.ProfessorRepository;
import dz.services.opensmtp.request.SubjectRequest;
import dz.services.opensmtp.response.SubjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @PostMapping("/subject")
    public ResponseEntity<String> CreateSubjectWithProfessor(@RequestBody SubjectRequest sReq) {
        Subject subject = new Subject(sReq);
        subject = subjectRepository.save(subject);

        for (String professor : sReq.getProfessor()) {
            Professor p = new Professor();
            p.setName(professor);
            List subjects = new ArrayList();
            subjects.add(subject);
            p.setSubjects(subjects);
            professorRepository.save(p);
        }
        return new ResponseEntity<String>("Record saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/subject")
    public ResponseEntity<SubjectResponse> getSubjectWithProfessors(@RequestParam Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        SubjectResponse sRes = new SubjectResponse();
        sRes.setName(subject.get().getName());

        List<Professor> professors = professorRepository.findProfessorsBySubjectsId(subject.get().getId());
        List<String> pName = new ArrayList<>();
        professors.forEach(p -> {
            pName.add(p.getName());
        });
        sRes.setProfessors(pName);

        return new ResponseEntity<SubjectResponse>(sRes, HttpStatus.OK);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Object> getSubjectWithId(@PathVariable("id") Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        try {
            return new ResponseEntity<Object>(subject.get(), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No record with the id [%s] was found", id));
        }

    }

}
