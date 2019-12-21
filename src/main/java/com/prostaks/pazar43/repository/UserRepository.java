package com.prostaks.pazar43.repository;
import com.prostaks.pazar43.models.Role;
import com.prostaks.pazar43.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);

}
