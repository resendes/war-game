package com.game.resources.exceptions;

import lombok.Getter;

@Getter
public class Error {

	public Error(String message) {
		this.message = message;
	}

	private String message;

}
