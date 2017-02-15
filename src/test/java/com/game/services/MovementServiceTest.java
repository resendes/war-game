package com.game.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.game.services.MovementService;
import com.game.services.exceptions.InvalidGroundException;
import com.game.services.exceptions.InvalidMilitaryUnitException;
import com.game.services.exceptions.InvalidMovementsException;

public class MovementServiceTest {

	private MovementService service;

	@Before
	public void init() {
		service = new MovementService();
	}

	@Test
	public void testInfantariaMovements() {
		assertThat( service.move( "infantaria", "eedrdde" ), equalTo( "3,EED,RD,DE" ) );
	}

	@Test
	public void testArtilhariaMovements() {
		assertThat( service.move( "artilharia", "eedrdde" ), equalTo( "3,EED,RD,DE" ) );
	}

	@Test
	public void testTanqueMovements() {
		assertThat( service.move( "tanque", "eedrdde" ), equalTo( "1,EEDRDDE" ) );
	}

	@Test
	public void testInfantariaMovementsSharingR() {
		assertThat( service.move( "infantaria", "dererdffeeee" ), equalTo( "5,DE,RE,RD,FFEE,EE" ) );
	}

	@Test
	public void testTanqueMovementsSharingR() {
		assertThat( service.move( "tanque", "eedfrred" ), equalTo( "2,EEDF,RRED" ) );
	}

	@Test(expected = InvalidMovementsException.class)
	public void testMovementsWhenEndsInRiver() {
		service.move( "tanque", "rrrrre" );
	}

	@Test(expected = InvalidMilitaryUnitException.class)
	public void testInvalidMilatyUnit() {
		service.move( "cavalaria", "dddd" );
	}

	@Test(expected = InvalidGroundException.class)
	public void testInvalidGround() {
		service.move( "infantaria", "ddddz" );
	}

	@Test(expected = InvalidMovementsException.class)
	public void testMovementsEndsWithR() {
		service.move( "infantaria", "r" );
	}

	@Test(expected = InvalidMovementsException.class)
	public void testEmptyMovements() {
		service.move( "infantaria", "" );
	}

	@Test(expected = InvalidMovementsException.class)
	public void testNullMovements() {
		service.move( "infantaria", null );
	}

}