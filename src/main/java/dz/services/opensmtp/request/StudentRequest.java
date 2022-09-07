package dz.services.opensmtp.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentRequest {

    private String name;
    private List<String> course;
}
