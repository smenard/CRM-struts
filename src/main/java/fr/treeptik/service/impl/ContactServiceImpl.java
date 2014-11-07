package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.ContactDao;
import fr.treeptik.entity.Contact;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public void add(Contact contact) throws ServiceException {
		try{
			contactDao.save(contact);
		}catch(DataAccessException e){
			throw new ServiceException(e,"ContactServiceImpl add");
		}
		
	}

	@Override
	public List<Contact> getAll() throws ServiceException {
		try{
			return contactDao.findAll();
		}catch(DataAccessException e){
			throw new ServiceException(e, "ContactServiceImpl getAll");
		}
		
	}

	@Override
	public Contact get(Integer id) throws ServiceException {
		try{
			return contactDao.findOne(id);
		}catch(DataAccessException e){
			throw new ServiceException(e, "ContactServiceImpl get");
		}
		
	}

	@Override
	public void delete(Integer contactId) throws ServiceException {
		try{
			contactDao.delete(contactId);
		}catch(DataAccessException e){
			throw new ServiceException(e,"ContactServiceImpl delete");
		}
		
		
	}

	@Override
	public List<Contact> getAllEntreprise(Integer entrepriseId) throws ServiceException {
		try{
			return contactDao.findAllEntreprise(entrepriseId);
		}catch(DataAccessException e){
			throw new ServiceException(e, "ContactServiceImpl getAllEntreprise");
		}
		
	}

	@Override
	public Contact getWithEchanges(Integer id) throws ServiceException {
		try{
			return contactDao.getWithEchanges(id);
		}catch(DataAccessException e){
			throw new ServiceException(e,"ContactServiceImpl getWithEchanges");
		}
	}
	
	
}
