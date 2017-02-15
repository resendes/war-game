package com.game.resources.exceptions;

import java.lang.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.game.services.exceptions.InvalidMovementsException;

@Provider
public class InvalidMovementsExceptionMapper implements ExceptionMapper<InvalidMovementsException> {

	@Override
	public Response toResponse(InvalidMovementsException exception) {
		Error error = new Error( exception.getMessage() );
		return Response.status( Status.BAD_REQUEST ).entity( error ).build();
	}
	
}
