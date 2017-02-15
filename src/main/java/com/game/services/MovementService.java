package com.game.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.game.models.Ground;
import com.game.models.MilitaryUnit;
import com.game.models.Shift;
import com.game.models.Shifts;
import com.game.services.exceptions.InvalidGroundException;
import com.game.services.exceptions.InvalidMilitaryUnitException;
import com.game.services.exceptions.InvalidMovementsException;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

@Stateless
public class MovementService {

	public String move(String militaryUnit, String ground) {
		validateGround( ground );
		return buildShifts( buildGrounds( ground ), buildMilitaryUnit( militaryUnit ) ).toString();
	}

	private void validateGround(String ground) {
		if (Strings.isNullOrEmpty( ground ) || ground.toUpperCase().endsWith( Ground.R.toString() ))
			throw new InvalidMovementsException();
	}

	private List<Ground> buildGrounds(String movements) {
		return Arrays.stream( movements.split( "" ) ).map( String::toUpperCase ).map( this::parseGroundValue )
				.collect( Collectors.toList() );
	}

	private MilitaryUnit buildMilitaryUnit(String militaryUnit) {
		try {
			return MilitaryUnit.valueOf( militaryUnit.toUpperCase() );
		} catch (Exception e) {
			throw new InvalidMilitaryUnitException( e );
		}
	}

	private Shifts buildShifts(List<Ground> grounds, MilitaryUnit unit) {
		Shifts shifts = new Shifts();
		grounds.forEach( (g) -> move( shifts.getShifts(), g, unit ) );

		return shifts;
	}

	private void move(List<Shift> shifts, Ground ground, MilitaryUnit unit) {
		Shift shift = Iterables.getLast( shifts );
		if (getShiftProgress( shift.getGrounds(), ground ) <= unit.getMovements())
			shift.addGround( ground );
		else
			moveNewShift( shifts, ground, unit );
	}

	private int getShiftProgress(List<Ground> grounds, Ground newMovement) {
		return getShiftProgress( grounds ) + newMovement.getMovements();
	}

	private int getShiftProgress(List<Ground> grounds) {
		return grounds != null ? grounds.stream().mapToInt( Ground::getMovements ).sum() : 0;
	}

	private void moveNewShift(List<Shift> shifts, Ground ground, MilitaryUnit unit) {
		List<Ground> lastShiftGrounds = Iterables.getLast( shifts ).getGrounds();

		shifts.add( new Shift() );
		updateLastShift( shifts, lastShiftGrounds, unit );
		move( shifts, ground, unit );
	}

	private void updateLastShift(List<Shift> shifts, List<Ground> grounds, MilitaryUnit unit) {
		if (Ground.R == Iterables.getLast( grounds )) {
			grounds.remove( grounds.size() - 1 );
			checkGroundsNotEmpty( grounds );
			move( shifts, Ground.R, unit );
			updateLastShift( shifts, grounds, unit );
		}
	}

	private void checkGroundsNotEmpty(List<Ground> grounds) {
		if (grounds.size() == 0)
			throw new InvalidMovementsException();
	}

	private Ground parseGroundValue(String ground) {
		try {
			return Ground.valueOf( ground );
		} catch (Exception e) {
			throw new InvalidGroundException( e );
		}
	}
}
