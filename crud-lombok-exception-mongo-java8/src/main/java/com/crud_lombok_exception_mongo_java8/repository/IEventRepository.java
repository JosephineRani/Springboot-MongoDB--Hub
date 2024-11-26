package com.crud_lombok_exception_mongo_java8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud_lombok_exception_mongo_java8.entity.Event;

@Repository
public interface IEventRepository extends MongoRepository<Event, String>{

}
