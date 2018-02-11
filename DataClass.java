package rest.web.messenger.database;
import java.util.HashMap;
import java.util.Map;

import rest.web.messenger.model.Message;
import rest.web.messenger.model.Profile;
public class DataClass {
	
	public static Map<Long, Message> messages=new HashMap<>();
	public static Map<String, Profile> profiles=new HashMap<>();

	
	public static Map<Long, Message> getMessages(){
		return messages;
		
	}
	public static Map<String, Profile> getProfiles(){
		return profiles;
		
	}
}
