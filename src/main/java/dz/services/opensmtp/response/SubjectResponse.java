package dz.services.opensmtp.response;


import dz.services.opensmtp.professor.Professor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectResponse {

    private String name;
    private List<String> professors;
}
