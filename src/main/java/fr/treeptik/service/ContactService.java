package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Contact;
import fr.treeptik.exception.ServiceException;


public interface ContactService {
	public void add(Contact contact)throws ServiceException;
    public List<Contact> getAll()throws ServiceException;
    public List<Contact> getAllEntreprise(Integer entrepriseId)throws ServiceException;
    public Contact get(Integer id)throws ServiceException;
    public Contact getWithEchanges(Integer id)throws ServiceException;
    public void delete(Integer contactId)throws ServiceException;
}
