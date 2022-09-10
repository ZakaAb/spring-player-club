package dz.services.opensmtp.subject;


import com.fasterxml.jackson.annotation.JsonBackReference;
import dz.services.opensmtp.professor.Professor;
import dz.services.opensmtp.request.StudentRequest;
import dz.services.opensmtp.request.SubjectRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors;

    public Subject(SubjectRequest sReq) {
        this.name = sReq.getName();
    }
}
