package rest.web.messenger.resource;

import rest.web.messenger.resource.profileResource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest_1")
public class ApplicationConfig_Profile extends Application {

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<>();
		RestResourceClasses(resources);
		return resources;
	}
  private void RestResourceClasses(Set<Class<?>> resources){
	  resources.add(profileResource.class);
  }
 
	
  
}

