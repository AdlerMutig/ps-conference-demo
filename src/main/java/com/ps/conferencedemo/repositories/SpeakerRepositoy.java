package com.ps.conferencedemo.repositories;

import com.ps.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepositoy extends JpaRepository<Speaker, Long> {
}
