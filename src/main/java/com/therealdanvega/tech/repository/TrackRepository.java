package com.therealdanvega.tech.repository;

import com.therealdanvega.tech.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Long> {

}
