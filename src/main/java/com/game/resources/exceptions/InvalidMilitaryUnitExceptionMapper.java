package com.game.resources.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.game.services.exceptions.InvalidMilitaryUnitException;

@Provider
public class InvalidMilitaryUnitExceptionMapper implements ExceptionMapper<InvalidMilitaryUnitException> {

	@Override
	public Response toResponse(InvalidMilitaryUnitException exception) {
		Error error = new Error( exception.getMessage() );
		return Response.status( Response.Status.BAD_REQUEST ).entity( error ).build();
	}

}
