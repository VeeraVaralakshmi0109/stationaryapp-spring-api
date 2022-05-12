package com.stationaryapp.stationaryappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationaryapp.stationaryappapi.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByEmailAndPassword(String email, String password);

}
