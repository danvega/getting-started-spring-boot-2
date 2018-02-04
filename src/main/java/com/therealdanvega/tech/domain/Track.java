package com.therealdanvega.tech.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Track {

    public Track(String name, String instructor, String location) {
        this.name = name;
        this.instructor = instructor;
        this.location = location;
    }

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String instructor;
    private String location;

    @OneToMany(mappedBy = "track")
    private Set<Student> students = new HashSet<>();
}
