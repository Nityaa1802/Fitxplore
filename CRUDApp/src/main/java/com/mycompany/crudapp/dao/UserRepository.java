package com.mycompany.crudapp.dao;

import com.mycompany.crudapp.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
 public Long countById(Integer id);
}
