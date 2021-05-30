package com.rishabh.rishabhtest.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.rishabhtest.models.Session;
import com.rishabh.rishabhtest.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

	@Autowired
	private SessionRepository sessionRepository;

	// what spring mvc dose it pass this list object to jackson which creates the
	// json of the list and return the
	// json object to the caller
	@GetMapping
	public List<Session> list() {
		System.out.println("in get request");
		return sessionRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}") // is add the extra id in root URL and we received
							// it as path variable
	public Session get(@PathVariable Long id) {
		return sessionRepository.findById(id).orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Session create(
			@RequestBody /* takes data as json and demarshell as args object */ final Session session) {

		// saveSndFlush() save the data in DB and commit simple save() dosen't
		System.out.println(session.getSessionDescription());
		// commit the data
		return sessionRepository.saveAndFlush(session);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {

		// also need to check for children records before deleting
		// deleting depends on the cascade method if session has children
		// records it will not allow to delete the records and will throw
		// foreign key constraint violation

		sessionRepository.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		// put is generally used to update all the attributes of object and
		// patch
		// is used to update portion of the object
		Session existingSession = sessionRepository.findById(id).orElse(null);

		// third parameter is the property which you dosen't want to update
		// if we will not add this as ignore property it will populate the
		// primary key
		// as null and when we will try to update the record it will throw the
		// exception because primary key can not be null;
		BeanUtils.copyProperties(session, existingSession, "sessionId");
		return sessionRepository.saveAndFlush(existingSession);
	}
}
