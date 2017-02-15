package com.game.models;

import java.util.List;

import lombok.Getter;

import com.google.common.collect.Lists;

@Getter
public class Shifts {
	private List<Shift> shifts;

	public Shifts() {
		this.shifts = Lists.newArrayList( new Shift() );
	}

	public String toString() {
		return shifts.size() + shifts.stream().map( Shift::toString ).reduce( "", (a, b) -> a + "," + b );
	}
}
