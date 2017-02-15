package com.game.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ground {
	E(1),
	D(2),
	F(2),
	R(3);

	private Integer movements;
}
