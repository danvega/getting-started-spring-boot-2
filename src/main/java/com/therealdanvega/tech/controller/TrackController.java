package com.therealdanvega.tech.controller;

import com.therealdanvega.tech.domain.Track;
import com.therealdanvega.tech.repository.TrackRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final TrackRepository trackRepository;

    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @RequestMapping("/")
    public List<Track> list() {
        return trackRepository.findAll();
    }

}
