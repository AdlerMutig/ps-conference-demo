package com.ps.conferencedemo.repositories;

import com.ps.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
//CRUD on the Session class
public interface SessionRepository extends JpaRepository<Session, Long> {

}
