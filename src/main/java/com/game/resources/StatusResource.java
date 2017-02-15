package com.game.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("status")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class StatusResource {

	@GET
	public String status() {
		return "OK";
	}

}
