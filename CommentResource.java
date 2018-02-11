package rest.web.messenger.resource;

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

import rest.web.messenger.model.Comment;
import rest.web.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService= new CommentService();
  
	
	
	@GET()
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId){
		return "the Comment Id id:" + commentId + "The messageId is:" +messageId;
		
	}
	@GET()
	public List<Comment> getAllComments(@PathParam("messageId") Long messageId){
		return commentService.getAllComments(messageId);
		}
	@POST()
	public Comment addMessage(@PathParam("messageId")long messageId,Comment comment)
	{
		return commentService.addComment(messageId, comment);
	}
	@PUT()
	@Path("{commentId}")
	public Comment updateMessage(@PathParam("messageId") Long messageId,@PathParam("commentId") Long Id ,Comment comment)
		{
		comment.setId(Id);
		return commentService.updateComment(messageId, comment);	
	    }
	@DELETE()
	@Path("{commentId}")
	public void  deleteMessage(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId){
		
		 commentService.removeComment(messageId, commentId);	
	}
	@GET()
	@Path("{commentId}")
	public Comment getMessage(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId){
		
		return commentService.removeComment(messageId, commentId);	
	}
}
