import javax.enterprise.inject.Produces;
import javax.faces.bean.CustomScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
//encapsule les ressources rest et contient les crud


@Path("/bibliotheque")
public class BibliothequeResource {
	
	static List<Livre> livres =new ArrayList<Livre>();
	@POST
	@Path("/ajout")
   @Consumes("application/xml")
	//@Consumes(MediaType.APPLICATION_XHTML)
	public String ajouterLivre(Livre livre)
	{
		if (livres.add(livre))
		return ("livre ajouté");
		return ("impossible d'ajouter le livre");
	}
	@GET
	@Path("/afficher")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Livre> afficherXML ()
	{
		return livres;
		
	}
	@GET
	@Path("/afficher")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Livre> afficherJSON ()
	{
		return livres;
		
	}
	
	@GET
	@Path("recherche/{isbn}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_XML)
	public Livre rechercheLivre(@PathParam("isbn")String isbn)
	{
		Livre Livre=null;
		for (Livre l:livres)
		{
			if (l.getIsbn().equals(isbn)) {
				Livre=l;
				
			}
		}
		return Livre;
	}
	@POST
	@Path("/modifier")
	@Consumes(MediaType.APPLICATION_XML)
	public String majLivre(Livre livre)
	{
		int index=livres.indexOf(livre);
		if (index!=-1) {
			livres.set(index, livre);
			return "livre modifié";
			
			
		}
		return "impossible";		
	}
	@Path("/supprimer")
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	public String supprimer(Livre l)
	{
		for (Livre liv:livres){
			if (liv.getIsbn()==l.getIsbn()) {
				livres.remove(liv);
				return "livre supprimer";
			}
			
		}
		return "livre nn supprimé";
	}
	@Path("/supprimer/{id}")
	@DELETE
	//@Consumes(MediaType.APPLICATION_XML)
	public String supprimerWithid(String id)
	{
		for (Livre liv:livres){
			if (liv.getIsbn().equals(id)) {
				livres.remove(liv);
				return "livre supprimer";
			}
			
		}
		return "livre nn supprimé";
	}
	

}
