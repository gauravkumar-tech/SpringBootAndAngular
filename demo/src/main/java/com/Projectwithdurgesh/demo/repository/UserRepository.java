package com.Projectwithdurgesh.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.Projectwithdurgesh.demo.Model.User;

public interface UserRepository extends CrudRepository<User, Integer>  {
	

}
