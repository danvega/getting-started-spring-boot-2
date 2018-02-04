package com.therealdanvega.tech.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    private Track java;

    @Before
    public void setUp() throws Exception {
        java = new Track("Java","Dan Vega","Cleveland");
        entityManager.persist(java);
        entityManager.flush();
        System.out.println("Java id: " + java.getId());
    }

    @Test
    public void whenFindByEmail_ThenReturnStudent() {
        // given
        Student joe = new Student("Joe","Thomas","joe.thomas@gmail.com");
        joe.setTrack(java);
        entityManager.persist(joe);
        entityManager.flush();

        // when
        Student found = studentRepository.findByEmail(joe.getEmail());

        // then
        assertThat(found.getEmail()).isEqualTo(joe.getEmail());
    }

    @Test
    public void whenFindByEmail_ThenReturnNull() {
        // given
        Student john = new Student("John","Thomas","john.thomas@gmail.com");
        john.setTrack(java);
        entityManager.persist(john);
        entityManager.flush();

        // when
        Student found = studentRepository.findByEmail("invalid.email@gmail.com");

        // then
        assertThat(found).isNull();
    }
}
