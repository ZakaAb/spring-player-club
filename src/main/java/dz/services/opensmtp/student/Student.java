package dz.services.opensmtp.student;


import dz.services.opensmtp.course.Course;
import dz.services.opensmtp.request.StudentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<Course> courses;

    public Student(StudentRequest req) {
        this.name = req.getName();
    }
}
