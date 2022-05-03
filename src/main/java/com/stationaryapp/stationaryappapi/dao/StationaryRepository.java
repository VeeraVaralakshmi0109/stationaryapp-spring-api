package com.stationaryapp.stationaryappapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stationaryapp.stationaryappapi.model.StationaryList;

public interface StationaryRepository extends JpaRepository<StationaryList, Integer> {

}
