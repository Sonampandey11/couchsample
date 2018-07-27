package com.couchdb.couchdb2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.couchdb.couchdb2.model.User;
import com.couchdb.couchdb2.service.UserServiceImpl;


@RestController
public class UserController {
	@Autowired
    UserServiceImpl userServiceImpl;
    
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User users =userServiceImpl.createUser(user);
        return new ResponseEntity<User>(users, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/readall") 
    public ResponseEntity<List<User>> readAll() {
        List<User> Users = userServiceImpl.viewAllUser();
        return new ResponseEntity<List<User>>(Users, HttpStatus.OK);
    }
    
    
    
   /* @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
    	User user1 = userServiceImpl.updateUser(user);
 	        return new ResponseEntity<User>(user1, HttpStatus.OK);

    }
    */
    
    /*@DeleteMapping("/delete") 
    public ResponseEntity<List<User>> delete(@RequestBody User user) {
        System.out.println("inside Deleted");
		return null;
    }*/
    
    
    @GetMapping(value = "/find/{id}") 
    public ResponseEntity<User> read(@PathVariable String id) {
        String user2 = userServiceImpl.findById(id);
        return new ResponseEntity<User>(HttpStatus.OK);

    }
    
    
    
    
}


