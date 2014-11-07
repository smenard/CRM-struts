package fr.treeptik.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.entity.Contact;
import fr.treeptik.entity.Entreprise;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.ContactService;
import fr.treeptik.service.EntrepriseService;
@Component(value = "contactAction")
@Scope("prototype")// et pas singleton car données membres
@Namespace("/contact")
public class ContactAction extends ActionSupport implements ModelDriven<Contact>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContactService contactService;
	@Autowired
	private EntrepriseService entrepriseService;
	
	private Contact contact = new Contact();
	private List<Contact> contacts = new ArrayList<Contact>();
	private List<Entreprise> entreprises = new ArrayList<Entreprise>();
	private Integer entrepriseId;

	public void validate(){
		try {
			entreprises = entrepriseService.getAll();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Contact getModel() {
		return contact;
	}
	@Action(value = "viewAction", results = {
			@Result(name = "success", location = "/contact/view.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String viewContact()  throws ServiceException{
//		contacts = contactService.getAllEntreprise(entrepriseId);
//		entreprise = entrepriseService.get(entrepriseId);
		contact = contactService.getWithEchanges(contact.getId());
		return "success";
	}
	@Action(value = "listAction", results = {
			@Result(name = "success", location = "/contact/list.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String listContactEntreprise()  throws ServiceException{
//		contacts = contactService.getAllEntreprise(entrepriseId);
//		entreprise = entrepriseService.get(entrepriseId);
		contacts = contactService.getAll();
		return "success";
	}
	@Action(value = "prepareAddAction", results = {
			@Result(name = "success", location = "/contact/add.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String prepareAdd()  throws ServiceException{
		entreprises = entrepriseService.getAll();
		return "success";
	}
	@Action(value = "addAction" ,results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/contact/add.jsp") }) // si erreurs de validation
	public String addContact() throws ServiceException  {
		System.out.println("ADD Contact");

		System.out.println(contact);
//		contact.setEntreprise(entreprise);
		contact.setEntreprise(entrepriseService.get(contact.getEntreprise().getId()));
		entreprises = entrepriseService.getAll();
		contactService.add(contact);

		return "success";
	}
	@Action(value = "deleteAction",results={
			@Result(name = "success",type="redirectAction",location="listAction.action")
	})
	@SkipValidation
	public String deleteContact()throws ServiceException {
		contactService.delete(contact.getId());
		return SUCCESS;
	}
	@Action(value = "initUpdateAction",results={
			@Result(name = "success",location="/contact/add.jsp")
	})
	@SkipValidation
	public String initUpdateContact()throws ServiceException {
		contact = contactService.get(contact.getId());
		entreprises = entrepriseService.getAll();
		return SUCCESS;
	}
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public List<Entreprise> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	public Integer getEntrepriseId() {
		return entrepriseId;
	}
	public void setEntrepriseId(Integer entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	
	

}
