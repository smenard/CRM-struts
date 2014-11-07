package fr.treeptik.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
@Entity
public class Entreprise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
	private Integer id;
	private String raisonSociale;
	@Type(type = "text")
	private String adresse;
	private String secteurActivite;
	@OneToMany(mappedBy="entreprise",cascade=CascadeType.ALL)
	private List<Contact> contacts;
	
	public Entreprise() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entreprise [id=");
		builder.append(id);
		builder.append(", raisonSociale=");
		builder.append(raisonSociale);
		builder.append(", secteurActivite=");
		builder.append(secteurActivite);
		builder.append("]");
		return builder.toString();
	}
	

}
