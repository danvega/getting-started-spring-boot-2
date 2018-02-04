package com.therealdanvega.tech;

import com.therealdanvega.tech.config.TechElevetorProperties;
import com.therealdanvega.tech.domain.Student;
import com.therealdanvega.tech.domain.Track;
import com.therealdanvega.tech.domain.StudentRepository;
import com.therealdanvega.tech.domain.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(TechElevetorProperties.class)
public class TechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechApplication.class, args);
	}

	@Bean
	@Profile("!unit")
	CommandLineRunner runner(StudentRepository studentRepository, TrackRepository trackRepository) {
		return args -> {
			Track java = new Track("Java","Dan Vega","Cleveland");
			Track dotnet = new Track(".NET","NOT Dan Vega","Cleveland");
			trackRepository.saveAll(Arrays.asList(java,dotnet));

			Student student = new Student("John","Smith","jsmith@gmail.com");
			student.setTrack(java);
			studentRepository.save(student);
		};
	}
}
