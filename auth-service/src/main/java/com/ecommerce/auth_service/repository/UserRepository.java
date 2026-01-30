//The repository is the layer that interacts with the database.
//With Spring Data JPA, you don’t need to write SQL —
//it’s generated automatically from method names

package com.ecommerce.auth_service.repository;

import com.ecommerce.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by username
    Optional<User> findByUsername(String username);

    // Check if a user exists by username
    boolean existsByUsername(String username);

    // Check if a user exists by email
    boolean existsByEmail(String email);
}
