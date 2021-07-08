package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Topic;
import com.springboot.service.TopicsService;

@RestController

public class TopicController {
	
	@Autowired
	private TopicsService topservice;
	
	
	@RequestMapping("/topics")
	public List<Topic> all_topics(){
		
		return topservice.getAllTopicList();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id)
	{
		return topservice.getTopic(id);
	}
}
