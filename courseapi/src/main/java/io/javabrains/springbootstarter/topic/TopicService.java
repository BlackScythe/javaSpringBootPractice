package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
//this is a singleton, it is created a single time throughout all the runtime
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Course> topics =  new ArrayList<>(Arrays.asList(
//            new Course("spring","Spring Framework", "Spring Framework description"),
//            new Course("java","Core Java", "Core Java description"),
//            new Course("javascript","Javascript", "Javascript description")
//    ));

    public List<Topic> getAllTopics(){
        //original method:
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return  topics;
    }

    public Topic getTopic(String id) {
        //original method:
        //return topics.stream()
        //.filter(t->t.getId().equals(id))
        //.findFirst()
        //.get();
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        //original method:
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        //original method:
        /*for(int i = 0; i < topics.size(); i++){
            if(topics.get(i).getId().equals(id)){
                topics.set(i, topic);
            }
        }*/

        //the id is unneeded if it comes in the object
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //original method:
        //topics.removeIf(t->t.getId().equals(id));

        topicRepository.delete(id);
    }


}
