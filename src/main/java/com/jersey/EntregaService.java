package com.jersey;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class EntregaService {
	@GET
	@Path("/entrega/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listEntregaById(@PathParam("id") int contatoId) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		EntregaModel entrega = null;
		try {
			Connection conn = connectionFactory.getConnection();
			EntregaDAO entregaDAO = new EntregaDAO();
			entrega = entregaDAO.listById(conn, contatoId);
			return Response.status(Response.Status.OK).entity(entrega).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GET
	@Path("/entrega")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listEntregaByNumPedido(@QueryParam("numPedido") int numPedido){
		ConnectionFactory connectionFactory = new ConnectionFactory();
		EntregaModel entrega = null;
		try {
			Connection conn = connectionFactory.getConnection();
			EntregaDAO entregaDAO = new EntregaDAO();
			entrega = entregaDAO.listByNumPedido(conn, numPedido);
			return Response.status(Response.Status.OK).entity(entrega).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GET
	@Path("/entregas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllEntregas() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		List<EntregaModel> entregas = null;
		try {
			Connection conn = connectionFactory.getConnection();
			EntregaDAO entregaDAO = new EntregaDAO();
			entregas = entregaDAO.list(conn);
			if (entregas == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				return Response.status(Response.Status.OK).entity(entregas).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	  
  	@POST
  	@Path("/entrega")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create( EntregaModel entrega){
    	 ConnectionFactory connectionFactory = new ConnectionFactory();
    	 if(entrega.getClientId() == null || entrega.getNumPedido()== null){
    		 return Response.status(Response.Status.BAD_REQUEST).entity("invalid params").build();
    	 }
		  try {
			Connection conn = connectionFactory.getConnection();
			EntregaDAO entregaDAO = new EntregaDAO();
			entregaDAO.insert(conn, entrega);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }

}
