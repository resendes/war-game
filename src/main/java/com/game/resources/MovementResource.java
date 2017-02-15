package com.game.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.game.services.MovementService;

@Path("move")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class MovementResource {

	@Inject
	private MovementService service;

	@GET
	@Path("{militaryUnit}")
	public String move(@PathParam("militaryUnit") String militaryUnit, @QueryParam("terreno") String ground) {
		return service.move( militaryUnit, ground );
	}
}
