package com.project.ToDoist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(value = "http://localhost:3000/")
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class ToDoist {

	public List<String> strings = new ArrayList<String>(Arrays.asList("Test 1","Test 2"));
	public static void main(String[] args) {
		SpringApplication.run(ToDoist.class, args);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/get")
	public ResponseEntity<List<String>> getData(){
		return new ResponseEntity<List<String>>(strings, HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.POST,value = "/post/{item}")
	public ResponseEntity<List<String>> postData(@PathVariable("item") String item){
		strings.add(item);
		return new ResponseEntity<List<String>>(strings, HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/update")
	public ResponseEntity<List<String>> updateData(){
		return new ResponseEntity<List<String>>(strings, HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/delete")
	public ResponseEntity<List<String>> deleteData(){
		return new ResponseEntity<List<String>>(strings, HttpStatus.ACCEPTED);
	}
}
