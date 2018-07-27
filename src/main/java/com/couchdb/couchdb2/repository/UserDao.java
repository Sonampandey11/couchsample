package com.couchdb.couchdb2.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.couchdb.couchdb2.model.User;

public interface UserDao extends CouchbaseRepository<User, String>{

}
