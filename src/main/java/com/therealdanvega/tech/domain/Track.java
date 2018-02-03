package com.therealdanvega.tech.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
