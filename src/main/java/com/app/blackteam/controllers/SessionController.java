package com.app.blackteam.controllers;

import com.app.blackteam.entities.Session;
import com.app.blackteam.repositories.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping(path = "/Session")
@Controller
public class SessionController {

  private final SessionRepository sessionRepository;

  public SessionController(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  @ResponseBody
  @GetMapping(path = "/all")
  public List<Session> getAllSessions() {
    return StreamSupport.stream(sessionRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @ResponseBody
  @GetMapping
  public Optional<Session> getAllTeamMates(@RequestBody UUID id) {
    return sessionRepository.findById(id);
  }

  @ResponseBody
  @PostMapping(path = "/addSession")
  public void addSession(@RequestBody String name) {
    sessionRepository.save(new Session(name));
  }

  @ResponseBody
  @PostMapping(path = "/updateSession")
  public void updateSession(
      @RequestBody String name,
      @RequestBody(required = false) UUID timeSlotId,
      @RequestBody(required = false) UUID speakerId,
      @RequestBody(required = false) UUID roomId,
      @RequestBody(required = false) UUID countId) {
    Session session =
        new Session(name)
            .setTimeSlotID(timeSlotId)
            .setSpeakerID(speakerId)
            .setRoomID(roomId)
            .setCountID(countId);

    session.setIsNew(false);

    sessionRepository.save(session);
  }

  @ResponseBody
  @PostMapping(path = "/deleteSession")
  public void deleteSession(@RequestBody UUID id) {
    sessionRepository.deleteById(id);
  }
}