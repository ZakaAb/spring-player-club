package dz.services.opensmtp.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponse {

    private Long id;
    private String studentName;
    private List<String> courses;
}
