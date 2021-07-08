package com.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.model.Topic;
@Component
@Service
public class TopicsService {
	private List<Topic> topicList = new ArrayList<>(Arrays.asList(

            new Topic("_spring", "_Spring FrameWork", "_Spring Description"),
            new Topic("spring", "Spring FrameWork", "Spring Description"),
            new Topic("java", "Java FrameWork", "Java Description")

    ));

	public List<Topic> getAllTopicList() {
		// TODO Auto-generated method stub
		return topicList;
	}
	
	public Topic getTopic(String id) {
		return topicList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}
}
