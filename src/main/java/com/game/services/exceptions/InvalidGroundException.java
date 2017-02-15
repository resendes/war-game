package com.game.services.exceptions;

public class InvalidGroundException extends RuntimeException {
	public InvalidGroundException(Exception e) {
		super( "Terreno não reconhecido", e );
	}
}
