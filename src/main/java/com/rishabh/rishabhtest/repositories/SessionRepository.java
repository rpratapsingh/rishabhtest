package com.rishabh.rishabhtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishabh.rishabhtest.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
