package com.stationaryapp.stationaryappapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationaryapp.stationaryappapi.dao.StationaryRepository;
import com.stationaryapp.stationaryappapi.model.StationaryList;
import com.stationaryapp.stationaryappapi.validator.StationaryValidator;

@Service
public class StationaryService {
	@Autowired
	StationaryRepository stationaryRepository;
	@Autowired
	StationaryValidator stationaryValidator;

	public void save(StationaryList stationaryList) throws Exception {
		try {
			stationaryValidator.stationaryValidation(stationaryList);
			stationaryRepository.save(stationaryList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}

	}
}