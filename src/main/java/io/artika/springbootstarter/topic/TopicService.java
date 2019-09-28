package io.artika.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> list = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring FrameWork", "Spring Framework description"),
            new Topic("spring2", "Spring FrameWork2", "Spring Framework description2"),
            new Topic("spring3", "Spring FrameWork3", "Spring Framework description3")
    )
    );

    public List<Topic> getAllTopic() {
        // return list;
        //converting thr iterable to list
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
        // return list.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        //list.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        for (int i = 0; i <= list.size(); i++) {
//            Topic t = list.get(i);
//            if (t.getId().equals(id)) {
//                list.set(i, topic);
//                return;
//            }
//
//        }
        //save can do both add and update
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //list.removeIf(topic -> topic.getId().equals(id));

        topicRepository.deleteById(id);
    }

}

