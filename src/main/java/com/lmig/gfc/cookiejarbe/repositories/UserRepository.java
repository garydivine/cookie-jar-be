package com.lmig.gfc.cookiejarbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.cookiejarbe.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

}
