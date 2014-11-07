package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Entreprise;
import fr.treeptik.exception.ServiceException;

public interface EntrepriseService {
	public void add(Entreprise entreprise)throws ServiceException;
    public List<Entreprise> getAll()throws ServiceException;
    public Entreprise get(Integer id)throws ServiceException;
    public Entreprise getWithContacts(Integer id)throws ServiceException;
    public void delete(Integer entrepriseId)throws ServiceException;
}
