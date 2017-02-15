package com.game.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MilitaryUnit {
	INFANTARIA( 6 ),
	ARTILHARIA( 5 ),
	TANQUE( 12 );

	private Integer movements;
}
