package com.accolite.rest.RestSample.resources;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.accolite.rest.RestSample.models.Message;
import com.accolite.rest.RestSample.services.MessageService;
@Path("messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessages() {
		 return messageService.getMessages();
	}
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessageById(@PathParam("messageId") int id) {
		//System.out.println(id);
		return messageService.getMessageById(id);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addMessage(Message m) {
		return messageService.addMessage(m);
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean modifyMessage(Message m) {
		return messageService.modifyMessage(m);
	}
	@DELETE
	@Path("/{content}")
	public boolean deleteMessage(@PathParam("content") String content) {
		return messageService.deleteMessage(content);
	}
}
