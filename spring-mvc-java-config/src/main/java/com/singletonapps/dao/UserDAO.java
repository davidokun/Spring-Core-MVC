package com.singletonapps.dao;

import com.singletonapps.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {


}
