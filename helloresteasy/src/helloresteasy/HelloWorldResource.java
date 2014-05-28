package helloresteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



@Path("/MyRestApplication")

public class HelloWorldResource {
@GET
@Produces("text/plain")
	public String SayHello(){
		
		return"HelloWorld !";
	}
@GET
@Path("/helloto1/{name}")
@Produces("text/plain")

public String SayHelloTo1(@PathParam("name")String n)
{
	
	return "Hello "+n+"!";
	
}


}
