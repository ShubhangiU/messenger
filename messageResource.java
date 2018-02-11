package rest.web.messenger.resource;

import java.net.URI;
import java.util.List;

//import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import rest.web.messenger.model.Message;
//import rest.web.messenger.resource.beans.MessageFilterBean;
import rest.web.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class messageResource {
	 
	MessageService messageService= new MessageService();
	
/*	@GET()
	public List<Message> getMessages(@BeanParam MessageFilterBean filterbean)
	{
	if (filterbean.getYear() > 0){
		return messageService.getAllMessagesForYear(filterbean.getYear());
	}
	if(filterbean.getStart() >= 0 && filterbean.getSize()>= 0){
		return messageService.getAllMessagesPaginated(filterbean.getStart(),filterbean.getSize());
	}
	
		return messageService.getAllMessages();
} 
	*/
	@GET()
	public List<Message> getAllMessages(){
		return messageService.getAllMessages();
		}
	
	
	@POST()
	public Response addMessage(Message message, @Context UriInfo uriInfo)
	{
		Message newMessage=messageService.addMessage(message);
		String newId= String.valueOf(message.getId());
		URI uri= (uriInfo.getAbsolutePathBuilder().path(newId).build());
			return	Response.created(uri).entity(newMessage).build();
			
			
		//return messageService.addMessage(message);
	}
	
	@PUT()
	@Path("{messageId}")
	public Response updateMessage(@PathParam("messageId") Long messageid, Message message)
		{
		message.setId(messageid);
		Message newMessage=messageService.updateMessage(message);
	return	Response.accepted(Status.ACCEPTED).entity(newMessage).build();
		
		  //return messageService.updateMessage(message);	
	    }
	
	@DELETE()
	@Path("{messageId}")
	public void deleteMessage(@PathParam("messageId") Long messageid){
		
		 messageService.removeMessage(messageid);	
	}
	@GET()
	@Path("{messageId}")
	public Message messagetest (@PathParam("messageId") Long messageId){
		
		return messageService.getMessage(messageId);
		
		
	}	
  
   
    @Path("/{messageId}/comments")
     public CommentResource getCommentResource(){
	  return new CommentResource() ;
}
   
}

