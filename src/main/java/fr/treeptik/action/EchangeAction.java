package fr.treeptik.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import fr.treeptik.entity.Echange;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.ContactService;
import fr.treeptik.service.EchangeService;

@Component(value = "echangeAction")
@Scope("prototype")// et pas singleton car données membres
@Namespace("/echange")
public class EchangeAction extends ActionSupport implements ModelDriven<Echange>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EchangeService echangeService;
	@Autowired
	private ContactService contactService;
	private Echange echange = new Echange();
	private String dateEchange;
	private List<Echange> echanges = new ArrayList<Echange>();
	private List<Contact> contacts = new ArrayList<Contact>();
	@Override
	public Echange getModel() {
		// TODO Auto-generated method stub
		return echange;
	}
	public void validate(){
		try {
			contacts = contactService.getAll();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(echange.getDate()== null){
			echange.setDate(new Date());
			
		}
	}
	@Action(value = "listAction", results = {
			@Result(name = "success", location = "/echange/list.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String listEchange()  throws ServiceException{
//		contacts = contactService.getAllEntreprise(entrepriseId);
//		entreprise = entrepriseService.get(entrepriseId);
		echanges = echangeService.getAll();
		return "success";
	}
	@Action(value = "prepareAddAction", results = {
			@Result(name = "success", location = "/echange/add.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String prepareAdd()  throws ServiceException{
		contacts = contactService.getAll();
		System.out.println(echange.getDate());
		if(echange.getDate()== null){
			echange.setDate(new Date());
			
		}
		System.out.println("Nouvelle date :"+ echange.getDate());
		return "success";
	}
	@Action(value = "addAction" ,results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/echange/add.jsp") }) // si erreurs de validation
	public String addEchange() throws ServiceException, ParseException  {
		System.out.println("ADD Contact");

		System.out.println(echange);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = formatter.parse(dateEchange);
//		echange.setDate(date);
//		contact.setEntreprise(entreprise);
		echange.setDate(getDatajava());
		echange.setContact(contactService.get(echange.getContact().getId()));
		contacts = contactService.getAll();
		echangeService.add(echange);

		return "success";
	}
	@Action(value = "deleteAction",results={
			@Result(name = "success",type="redirectAction",location="listAction.action")
	})
	@SkipValidation
	public String deleteEchange()throws ServiceException {
		echangeService.delete(echange.getId());
		return SUCCESS;
	}
	@Action(value = "initUpdateAction",results={
			@Result(name = "success",location="/echange/add.jsp")
	})
	@SkipValidation
	public String initUpdateEntreprise()throws ServiceException {
		echange = echangeService.get(echange.getId());
		contacts = contactService.getAll();
		System.out.println("Date"+echange.getDate());
		return SUCCESS;
	}
	//return today date
		public Date getTodayDate(){
	 
			return new Date();
		}
	public Echange getEchange() {
		return echange;
	}
	public void setEchange(Echange echange) {
		this.echange = echange;
	}
	public List<Echange> getEchanges() {
		return echanges;
	}
	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getDateEchange() {
		return dateEchange;
	}
	public void setDateEchange(String dateEchange) {
		this.dateEchange = dateEchange;
	}
	public Date getDatajava() {
        // DD-MM-YYYY HH:mm
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;
        
        try {
            date = formatter.parse(dateEchange);
        } catch (ParseException e) {
            return date;
        }
        return date;
    }
	

}
