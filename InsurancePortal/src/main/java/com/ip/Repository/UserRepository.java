package com.ip.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ip.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserName(String name);
}
