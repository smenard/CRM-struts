package fr.treeptik.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
@Entity
public class Echange implements Serializable{

	public enum TypeEchange{MAIL,TELEPHONE}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
	private Integer id;
	private TypeEchange type;
	private Date date;
	@Type(type = "text")
	private String commentaire;
	@ManyToOne
	private Contact contact;
	public Echange() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TypeEchange getType() {
		return type;
	}
	public void setType(TypeEchange type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Echange [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", date=");
		builder.append(date);
		builder.append(", commentaire=");
		builder.append(commentaire);
		builder.append("]");
		return builder.toString();
	}
	
}
