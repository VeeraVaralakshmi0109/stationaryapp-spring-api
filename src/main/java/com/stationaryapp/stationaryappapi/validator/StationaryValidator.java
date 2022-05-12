package com.stationaryapp.stationaryappapi.validator;

import org.springframework.stereotype.Component;

import com.stationaryapp.stationaryappapi.model.StationaryList;

@Component
public class StationaryValidator {

	public void stationaryValidation(StationaryList stationaryList) throws Exception {
		if (stationaryList.getItemsname() == null || (stationaryList.getItemsname()).trim() == "") {
			throw new Exception("Invalid Item Name");
		}

		if (stationaryList.getPrice() == 0 || stationaryList.getPrice() <= 0) {
			throw new Exception("invalid price");
		}

		if (stationaryList.getBrandname() == null || (stationaryList.getBrandname()).trim() == "") {
			throw new Exception("invalid hotel name");
		}

	}

}
