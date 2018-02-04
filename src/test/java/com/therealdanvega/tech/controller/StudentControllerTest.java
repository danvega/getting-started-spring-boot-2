package com.therealdanvega.tech.controller;

import com.therealdanvega.tech.domain.Student;
import com.therealdanvega.tech.domain.StudentRepository;
import com.therealdanvega.tech.domain.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ActiveProfiles("unit")
public class StudentControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    private Track java;

    @Before
    public void setUp() throws Exception {
        java = new Track("Java","Dan Vega","Cleveland");
    }

    @Test
    public void givenStudents_whenListStudents_thenReturnJsonArray() throws Exception {
        Student joe = new Student("Joe","Thomas","joe.thomas@gmail.com");
        Student john = new Student("John","Thomas","john.thomas@gmail.com");
        Student jim = new Student("Jim","Thomas","jim.thomas@gmail.com");

        List<Student> students = Arrays.asList(joe,john,jim);
        students.forEach(student -> student.setTrack(java));

        given(studentRepository.findAll()).willReturn(students);

        mvc.perform(get("/students/")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].firstName", is(joe.getFirstName())))
            .andExpect(jsonPath("$[0].lastName", is(joe.getLastName())))
            .andExpect(jsonPath("$[0].email", is(joe.getEmail())))
            .andExpect(jsonPath("$[0].track.name", is(joe.getTrack().getName())));
    }

}
