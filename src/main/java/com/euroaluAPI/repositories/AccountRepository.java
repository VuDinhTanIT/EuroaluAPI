package com.euroaluAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.euroaluAPI.models.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
//JpaSpecificationExecutor<Account> 
{
	Optional<Account> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
