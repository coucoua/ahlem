package Livre;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="book")

public class Livre {
private String isbn;
private String titre;
@XmlAttribute("id")
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
@XmlElement("Intitule")
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Livre(String isbn, String titre) {
	super();
	this.isbn = isbn;
	this.titre = titre;
}
public Livre() {
	super();
	
}
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
	result = prime * result + ((titre == null) ? 0 : titre.hashCode());
	return result;
}
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Livre other = (Livre) obj;
	if (isbn == null) {
		if (other.isbn != null)
			return false;
	} else if (!isbn.equals(other.isbn))
		return false;
	if (titre == null) {
		if (other.titre != null)
			return false;
	} else if (!titre.equals(other.titre))
		return false;
	return true;
}

}
