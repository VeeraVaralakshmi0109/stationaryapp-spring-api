package com.stationaryapp.stationaryappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stationaryapp.stationaryappapi.dao.StationaryRepository;
import com.stationaryapp.stationaryappapi.model.StationaryList;

@RestController
public class StationaryController {

	@Autowired
	StationaryRepository stationaryRepository;

	@PostMapping("stationaryapp_List/save")
	public StationaryList save(@RequestBody StationaryList stationarylist) {
		System.out.println(stationarylist);
		stationaryRepository.save(stationarylist);
		System.out.println("registered");
		return stationarylist;

	}

	@DeleteMapping("stationaryapp_List/{id}")
	public void delete(@PathVariable("id") Integer id) {
		stationaryRepository.deleteById(id);
	}

	@PutMapping("stationaryapp_List/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody StationaryList stationarylist) {
		stationarylist.setId(id);
		stationaryRepository.save(stationarylist);

	}

	@GetMapping("stationaryapp_List/listStationary")
	public List<StationaryList> findAll() {
		List<StationaryList> listStationary = stationaryRepository.findAll();
		return listStationary;

	}

	@GetMapping("stationaryapp_List/{id}")
	public StationaryList findById(@PathVariable("id") Integer id) {
		Optional<StationaryList> stationarylist = stationaryRepository.findById(id);
		if (stationarylist.isPresent()) {
			StationaryList obj = stationarylist.get();
			return obj;
		} else {
			return null;

		}
	}

}
