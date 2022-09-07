package dz.services.opensmtp.student;


import dz.services.opensmtp.course.Course;
import dz.services.opensmtp.course.CourseRepository;
import dz.services.opensmtp.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest sRequest) {
        Student student = new Student(sRequest);
        student = studentRepository.save(student);

        for (String s: sRequest.getCourse()) {
            Course c = new Course();
            c.setName(s);
            c.setStudent(student);

            courseRepository.save(c);
        }
    return new ResponseEntity<String>("Record saved successfully", HttpStatus.CREATED);
    }
}
