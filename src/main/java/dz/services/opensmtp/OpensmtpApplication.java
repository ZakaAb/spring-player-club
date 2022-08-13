package dz.services.opensmtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class OpensmtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpensmtpApplication.class, args);
	}


	@GetMapping(value = "/api")
	public List hello() {
		List<String> myList = new ArrayList<>();

		/**
		 * yes this my first comment
		 */
		Person p = new Person(1, "zaki", 29);
		myList.add(p.description());

		return myList;
	}

}
