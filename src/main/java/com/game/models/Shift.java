package com.game.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.google.common.collect.Lists;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Shift {
	private List<Ground> grounds;

	public void addGround(Ground ground) {
		if (grounds == null)
			grounds = Lists.newArrayList();
		grounds.add( ground );
	}

	public String toString() {
		return grounds.stream().map( Ground::toString ).reduce( "", String::concat );
	}
}
