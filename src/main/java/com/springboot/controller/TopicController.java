package com.springboot.controller;

import org.springframework.http.HttpHeaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Topic;
import com.springboot.service.TopicsService;

@RestController

public class TopicController {
	
	@Autowired
	private TopicsService topservice;
	
	
	@GetMapping("/topics")
	public List<Topic> all_topics(){
		
		return topservice.getAllTopicList();
	}
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopic(@PathVariable("id") String id)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Header", "Header'da beni goreceksin");
		
		return new ResponseEntity<Topic>(topservice.getTopic(id),headers,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/topics/add",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Topic> createTopic (@RequestBody Topic topic)
	{
			Topic returnVal = new Topic();
			returnVal.setId("Go");
			returnVal.setName("Go");
			returnVal.setDescription("Go");
			
			return new ResponseEntity<Topic>(returnVal,HttpStatus.OK);
	}
	
	@DeleteMapping (value = "/topics/delete/{id}")
	public ResponseEntity<Topic> deleteTopic(@PathVariable String id){
		var isRemoved = topservice.delete(id);
		
		if(!isRemoved)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Topic> (HttpStatus.OK);
	}
	
	@PutMapping(value = "/topics/put/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Topic> putTopic(@PathVariable String id){
		
		Topic topic = new Topic();
		topic.setId("Go");
		return new ResponseEntity<Topic>(topic,HttpStatus.OK);
	}
}
