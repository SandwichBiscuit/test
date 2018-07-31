package com.springboot.ps;

import org.springframework.data.repository.CrudRepository;

import com.springboot.entiy.User;

public interface UserRepoitory extends CrudRepository<User, Integer>{

}
