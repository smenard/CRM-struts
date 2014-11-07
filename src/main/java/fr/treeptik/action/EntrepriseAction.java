package fr.treeptik.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fr.treeptik.entity.Entreprise;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.EntrepriseService;
@Component(value = "entrepriseAction")
@Scope("prototype")// et pas singleton car données membres
@Namespace("/entreprise")
public class EntrepriseAction extends ActionSupport implements ModelDriven<Entreprise>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EntrepriseService entrepriseService;
	private Entreprise entreprise = new Entreprise();
	private List<Entreprise> entreprises = new ArrayList<Entreprise>();
	@Override
	public Entreprise getModel() {
		// TODO Auto-generated method stub
		return entreprise;
	}
	@Action(value = "viewAction", results = {
			@Result(name = "success", location = "/entreprise/view.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String viewEntreprise() throws ServiceException {
		entreprise = entrepriseService.getWithContacts(entreprise.getId());
		return "success";
	}
	@Action(value = "listAction", results = {
			@Result(name = "success", location = "/entreprise/list.jsp")})
	@SkipValidation // pour ne pas faire la validation 
	public String listEntreprises() throws ServiceException {
		entreprises = entrepriseService.getAll();
		return "success";
	}

	@Action(value = "addAction" ,results = {
			@Result(name = "success", type = "redirectAction", location = "listAction.action"),
			@Result(name = "input", location = "/entreprise/add.jsp") }) // si erreurs de validation
	public String addEntreprise() throws ServiceException {
		System.out.println("ADD entreprise");
		System.out.println(entreprise);
		
		entrepriseService.add(entreprise);

		return "success";
	}
	@Action(value = "deleteAction",results={
			@Result(name = "success",type="redirectAction",location="listAction.action")
	})
	@SkipValidation
	public String deleteEntreprise()throws ServiceException {
		entrepriseService.delete(entreprise.getId());
		return SUCCESS;
	}
	@Action(value = "initUpdateAction",results={
			@Result(name = "success",location="/entreprise/add.jsp")
	})
	@SkipValidation
	public String initUpdateEntreprise()throws ServiceException {
		entreprise = entrepriseService.get(entreprise.getId());
		
		return SUCCESS;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	

	
}
