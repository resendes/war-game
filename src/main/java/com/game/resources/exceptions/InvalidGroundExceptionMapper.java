package com.game.resources.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.game.services.exceptions.InvalidGroundException;

@Provider
public class InvalidGroundExceptionMapper implements ExceptionMapper<InvalidGroundException> {

	@Override
	public Response toResponse(InvalidGroundException exception) {
		Error error = new Error( exception.getMessage() );
		return Response.status( Response.Status.BAD_REQUEST ).entity( error ).build();
	}

}
