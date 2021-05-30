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

import com.rishabh.rishabhtest.models.Speaker;
import com.rishabh.rishabhtest.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

	@Autowired
	private SpeakerRepository speakerRepository;

	// what spring mvc dose it pass this list object to jacson which creates the
	// json of the list and return the
	// json object to the caller
	@GetMapping
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}") // is add the extra id in root url aand we received
							// it as path variable
	public Speaker get(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {

		// also need to check for children records before deleting
		// deleting depends on the cascade method if session has children
		// records it will not allow to delete the records and will throw
		// foreign key constraint violation

		speakerRepository.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		// put is generally used to update all the attributes of object and
		// patch
		// is used to update portion of the object
		Speaker existingSpeaker = speakerRepository.getOne(id);

		// third parameter is the property which you dosen't want to update
		// if we will not add this as ignore property it will populate the
		// primary key
		// as null and when we will try to update the record it will throw the
		// exception because primary key can not be null;
		BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(existingSpeaker);
	}
}
