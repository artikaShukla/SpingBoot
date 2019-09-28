package io.artika.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface TopicRepository extends CrudRepository<Topic, String > {



}
