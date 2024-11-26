package com.crud_lombok_exception_mongo_java8.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud_lombok_exception_mongo_java8.entity.Event;
import com.crud_lombok_exception_mongo_java8.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EventController {

	private final EventService eventService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		Event eventObj = eventService.createEvent(event);
		return new ResponseEntity<Event>(eventObj, HttpStatusCode.valueOf(200));
	}

	@GetMapping("/get")
	public List<Event> getEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/get-event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable String id) {
		Event event = eventService.getByEvent(id);
		return ResponseEntity.ok(event);
	}

	@PutMapping("/update")
	public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
		Event eventObj = eventService.updateEvent(event);
		return ResponseEntity.ok(eventObj);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
		eventService.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}

}
