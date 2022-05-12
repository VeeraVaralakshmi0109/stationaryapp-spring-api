package com.stationaryapp.stationaryappapi.dto;

import lombok.Data;

@Data
public class MessageDTO {

	public MessageDTO(String string) {
		message = string;
	}

	private String message = null;



}
