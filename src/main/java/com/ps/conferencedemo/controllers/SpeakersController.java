package com.ps.conferencedemo.controllers;

import com.ps.conferencedemo.models.Session;
import com.ps.conferencedemo.models.Speaker;
import com.ps.conferencedemo.repositories.SpeakerRepositoy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepositoy speakerRepositoy;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepositoy.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepositoy.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepositoy.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting
        speakerRepositoy.deleteById(id);
    }

    //Update session record
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Session session) {
        Speaker existingSession = speakerRepositoy.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "speaker_id");
        return speakerRepositoy.saveAndFlush(existingSession);
    }
}