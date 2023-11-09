package com.thiunuwan.authservice.repository;


import com.thiunuwan.authservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserCredentialRepository  extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByUsername(String username);

//    List<UserCredential> findAllById(int roleId);

//    List<UserCredential> findAllByRole(int roleId);

    @Query("SELECT u FROM UserCredential u JOIN u.authorities a WHERE a.roleId = ?1")
    List<UserCredential> findUsersByRoleId(int roleId);
}
