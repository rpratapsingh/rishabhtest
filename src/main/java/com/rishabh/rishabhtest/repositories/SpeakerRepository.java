package com.rishabh.rishabhtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.rishabhtest.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
