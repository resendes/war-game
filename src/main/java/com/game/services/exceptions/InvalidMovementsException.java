package com.game.services.exceptions;

public class InvalidMovementsException extends RuntimeException {
	public InvalidMovementsException() {
		super( "Não foi possível percorrer o caminho com a unidade militar" );
	}
}
