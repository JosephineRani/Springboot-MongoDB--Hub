package com.crud_lombok_exception_mongo_java8.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud_lombok_exception_mongo_java8.entity.Event;
import com.crud_lombok_exception_mongo_java8.exception.ResourceNotFoundException;
import com.crud_lombok_exception_mongo_java8.repository.IEventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

	public final IEventRepository eventRepository;

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event getByEvent(String id) {
		return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not Found"));
	}

	public Event updateEvent(Event event) {
		Event existingEvent = eventRepository.findById(event.getId()).get();
		
		Event newEvent = existingEvent.toBuilder()
				.name(event.getName())
				.location(event.getLocation())
				.image(event.getImage())
				.registerLink(event.getRegisterLink())
				.attendees(event.getAttendees())
				.startDate(event.getStartDate())
				.endDate(event.getEndDate())
				.startTime(event.getStartTime())
				.endTime(event.getEndTime())
				.organizedBy(event.getOrganizedBy())
				.build();
		eventRepository.save(newEvent);
		return newEvent;
	}

	public void deleteEvent(String id) {
		if (!eventRepository.existsById(id)) {
			throw new ResourceNotFoundException("Resource Not Found" + id);
		}
		eventRepository.deleteById(id);
	}
}
