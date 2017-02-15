package com.game.services.exceptions;

public class InvalidMilitaryUnitException extends RuntimeException {
	public InvalidMilitaryUnitException(Exception e) {
		super( "Unidade militar não reconhecida", e );
	}
}
