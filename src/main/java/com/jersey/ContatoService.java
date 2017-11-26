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
public class ContatoService {
	  @GET
	  @Path("/contatos")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listAllContatos() {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  List<ContatoModel> contatos = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			ContatoDAO contatoDAO = new ContatoDAO();
			contatos = contatoDAO.list(conn);
			
			if(contatos == null){
				return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				return Response.status(Response.Status.OK).entity(contatos).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
	  @GET
	  @Path("/contatoId/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listContatoById(@PathParam("id") int contatoId) {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  ContatoModel contato = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			ContatoDAO contatoDAO = new ContatoDAO();
			contato = contatoDAO.listById(conn, contatoId);
			return Response.status(Response.Status.OK).entity(contato).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
	  @GET
	  @Path("/contato/{name}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listContatoByNameEmail(@PathParam("name") String contatoName, @QueryParam("email") String contatoEmail) {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  ContatoModel contato = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			ContatoDAO contatoDAO = new ContatoDAO();
			contato = contatoDAO.listByNameEmail(conn, contatoName, contatoEmail);
			return Response.status(Response.Status.OK).entity(contato).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
      	@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create( ContatoModel contato){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				ContatoDAO contatoDAO = new ContatoDAO();
				contatoDAO.insert(conn, contato);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }

      	@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("/{id}")
		public Response update( ContatoModel contato, @PathParam("id") int id){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				ContatoDAO contatoDAO = new ContatoDAO();
				contatoDAO.update(conn, contato, id);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }

      	@DELETE
	    @Path("/{id}")
	    public Response delete( @PathParam("id") int id){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				ContatoDAO contatoDAO = new ContatoDAO();
				contatoDAO.delete(conn, id);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }


}
