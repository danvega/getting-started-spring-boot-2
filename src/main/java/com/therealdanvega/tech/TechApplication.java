package com.therealdanvega.tech;

import com.therealdanvega.tech.domain.Student;
import com.therealdanvega.tech.domain.Track;
import com.therealdanvega.tech.repository.StudentRepository;
import com.therealdanvega.tech.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class TechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechApplication.class, args);
	}

	@Bean
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
