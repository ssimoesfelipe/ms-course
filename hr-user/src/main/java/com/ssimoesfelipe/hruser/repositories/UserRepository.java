package com.ssimoesfelipe.hruser.repositories;

import com.ssimoesfelipe.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
