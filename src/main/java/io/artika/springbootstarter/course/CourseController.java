package io.artika.springbootstarter.course;

import io.artika.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topic/{id}/courses")
    public List<Course> getAllCourse(@PathVariable String id) {
        return courseService.getAllCourse(id);

    }

    @RequestMapping("/topic/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
