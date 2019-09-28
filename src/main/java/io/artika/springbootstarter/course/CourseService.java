package io.artika.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;



    public List<Course> getAllCourse(String topicId) {
         List<Course> topics = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(topics::add);
        return topics;
    }

    public Optional<Course> getCourse(String id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //list.removeIf(topic -> topic.getId().equals(id));

        courseRepository.deleteById(id);
    }

}

